package se.mattias.drools.moms;

import org.drools.core.event.AfterActivationFiredEvent;
import org.drools.core.event.rule.impl.AfterActivationFiredEventImpl;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.event.rule.*;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Inherited;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import se.mattias.drools.modell.*;

public class App {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            while (true) {
                System.out.println("Väntar på anrop...\n");
                try (Socket s = serverSocket.accept();
                     ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                     ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())) {

                    //Ta emot fakturan
                    Leverantorsfaktura leverantorsfaktura = (Leverantorsfaktura) ois.readObject();
                    MittForetagBasinfo basinfo = Fakta.taEmotBasinfo();
                    System.out.println("******* Inkommande data *******");
                    System.out.println("Tar emot inkommande leverantörsfaktura och basinfo");

                    //Tillför info om leverantörs verksamheter
                    Leverantor leverantor = leverantorsfaktura.getLeverantor();
                    String momsregnr = leverantorsfaktura.getLeverantor().getMomsregnr();
                    try {
                        List<String> snikoder = leverantor.HamtaSNI(momsregnr);
                        leverantor.setVerksamheter(snikoder);
                    } catch (Exception ex) {
                        System.out.println("Kunde inte hämta leverantörens SNI-koder.");
                    }

                    //Starta en StatelessKieSession
                    System.out.println("\n******* Startar StatelessKieSession*******");
                    KieServices ks = KieServices.Factory.get();
                    KieContainer kContainer = ks.getKieClasspathContainer();
                    StatelessKieSession kSession = kContainer.newStatelessKieSession("rules.ml.8kap.basic");

                    //Registrera Eventlisteners
                    kSession.addEventListener(new DefaultAgendaEventListener() {
                        @Override
                        public void beforeMatchFired(BeforeMatchFiredEvent event) {
                            System.out.println("Träffad regel:\t\t" + event.getMatch().getRule().getName());
                        }
                    });
                    kSession.addEventListener(new DefaultRuleRuntimeEventListener(){
                        @Override
                        public void objectInserted(ObjectInsertedEvent event){
                            System.out.println("Tillfört objekt:\t" + event.getObject());
                        }
                        @Override
                        public void objectUpdated(ObjectUpdatedEvent event){
                            System.out.println("Modifierat objekt:\t" + event.getObject());
                        }
                    });

                    //Sätt globala variabler
                    Set<Meddelande> meddelanden = new HashSet<>();
                    kSession.setGlobal("gMeddelanden", meddelanden);

                    //Tillför fakta i sessionen och exekvera reglerna
                    System.out.println("\n******** Kör regelmotorn ********");
                    Command insertLeverantorsfaktura = ks.getCommands().newInsert(leverantorsfaktura, "lFakturaUt");
                    Command insertBasinfo = ks.getCommands().newInsert(basinfo, "basinfoUt");
                    Command fireAllRules = ks.getCommands().newFireAllRules("firedUt");
                    List<Command> cmds = new ArrayList<>();
                    cmds.add(insertLeverantorsfaktura);
                    cmds.add(insertBasinfo);
                    cmds.add(fireAllRules);
                    ExecutionResults execSvar = kSession.execute(ks.getCommands().newBatchExecution(cmds));

                    //Redovisa svar
                    System.out.println("\n******* Svar från regelmotorn *******");
                    for (Meddelande m : meddelanden) {
                        System.out.println("Svarstyp:\t\t " + m.getTyp());
                        System.out.println("Meddelande:\t\t " + m.getSvarsinfo());
                        System.out.println("Att komplettera: " + m.getAttKomplettera() + "\n");
                    }
                    Svar svar = new Svar(meddelanden, (Leverantorsfaktura) execSvar.getValue("lFakturaUt"));
                    System.out.println("Svarsobjekt: " + svar.getLeverantorsfaktura() + "\n");

                    //Skicka svar till klient
                    oos.writeObject(svar);
                    TimeUnit.MILLISECONDS.sleep(100);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}