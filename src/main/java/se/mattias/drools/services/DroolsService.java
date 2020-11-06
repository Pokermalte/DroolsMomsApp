package se.mattias.drools.services;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.event.rule.*;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.mattias.drools.util.Util;
import se.mattias.model.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DroolsService {
    private KieServices kieServices;
    private StatelessKieSession kieSession;

    public DroolsService(KieServices kieServices, StatelessKieSession kieSession){
        this.kieServices = kieServices;
        this.kieSession = kieSession;
    }

    private static final Logger LOG = LoggerFactory.getLogger(DroolsService.class);

    public Svar getSvar(Leverantorsfaktura leverantorsfaktura) {

        //H�mta basinfo
        MittForetagBasinfo basinfo = Util.taEmotBasinfo();

        //H�mta info om leverant�rs verksamheter
        Leverantor leverantor = leverantorsfaktura.getLeverantor();
        String momsregnr = leverantor.getMomsregnr();
        try {
            LOG.debug("H�mtar SNI-koder f�r " + momsregnr);
            List<String> snikoder = Util.hamtaSNI(momsregnr);
            leverantor.setVerksamheter(snikoder);
        } catch (Exception ex) {
            LOG.warn("Kunde inte h�mta leverant�rens SNI-koder. " + ex);
        }

        //Registrera Eventlisteners
        kieSession.addEventListener(new DefaultAgendaEventListener() {
            @Override
            public void beforeMatchFired(BeforeMatchFiredEvent event) {
                LOG.debug("Tr�ffad regel:\t\t" + event.getMatch().getRule().getName());
            }
        });
        kieSession.addEventListener(new DefaultRuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent event) {
                LOG.debug("Tillf�rt objekt:\t" + event.getObject());
            }

            @Override
            public void objectUpdated(ObjectUpdatedEvent event) {
                LOG.debug("Modifierat objekt:\t" + event.getObject());
            }
        });

        //S�tt globala variabler
        Set<Meddelande> meddelanden = new HashSet<>();
        kieSession.setGlobal("gMeddelanden", meddelanden);

        //Tillf�r fakta i sessionen och exekvera reglerna
        LOG.debug("******** K�r regelmotorn ********");
        Command insertLeverantorsfaktura = kieServices.getCommands().newInsert(
                leverantorsfaktura, "lFakturaUt");
        Command insertBasinfo = kieServices.getCommands().newInsert(basinfo, "basinfoUt");
        Command fireAllRules = kieServices.getCommands().newFireAllRules("firedUt");
        List<Command> cmds = new ArrayList<>();
        cmds.add(insertLeverantorsfaktura);
        cmds.add(insertBasinfo);
        cmds.add(fireAllRules);
        ExecutionResults execSvar = kieSession.execute(kieServices.getCommands().newBatchExecution(cmds));

        //Logga svar
        LOG.debug("******* Svar fr�n regelmotorn *******");
        for (Meddelande m : meddelanden) {
            LOG.debug("Svarstyp:\t\t " + m.getTyp());
            LOG.debug("Meddelande:\t\t " + m.getSvarsinfo());
            LOG.debug("Att komplettera: " + m.getAttKomplettera());
        }
        Svar svar = new Svar(meddelanden, (Leverantorsfaktura) execSvar.getValue("lFakturaUt"));
        LOG.debug("Svarsobjekt: " + svar.getLeverantorsfaktura());

        //Returnera svar
        return svar;
    }
}
