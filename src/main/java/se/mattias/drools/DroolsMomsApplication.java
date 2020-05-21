package se.mattias.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("se.mattias.drools")
public class DroolsMomsApplication {
    public static void main(String[] args){
        SpringApplication.run(DroolsMomsApplication.class, args);
    }
}