package se.mattias.drools.configurations;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig{
    private KieServices ks = KieServices.Factory.get();

    @Bean
    public KieServices kieServices(){return KieServices.Factory.get();}

    @Bean
    public StatelessKieSession kieSession(){
        ReleaseId releaseId = ks.newReleaseId(
                "se.mattias.rules", "kie-moms", "1.0-SNAPSHOT");
        KieContainer kieContainer = ks.newKieContainer(releaseId);
        return kieContainer.newStatelessKieSession();
    }
}
