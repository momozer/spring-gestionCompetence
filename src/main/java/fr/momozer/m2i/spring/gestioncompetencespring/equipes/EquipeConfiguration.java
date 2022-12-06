package fr.momozer.m2i.spring.gestioncompetencespring.equipes;

import fr.momozer.m2i.spring.gestioncompetencespring.personnes.PersonneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EquipeConfiguration {
    private static final Logger logger =  LoggerFactory.getLogger(EquipeConfiguration.class);

    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository, PersonneService personneService){
        logger.debug("Création du bean EquipeService");
        return new EquipeServiceImp(equipeRepository, personneService);
    }
}
