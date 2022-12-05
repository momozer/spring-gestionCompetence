package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.momozer.m2i.spring.gestioncompetencespring.competences.CompetenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonneConfiguration {

    @Bean
    public PersonneService personneService(PersonneRepository personneRepository,  CompetenceService competenceService, ObjectMapper objectMapper){
        return new PersonneServiceImpl(personneRepository, competenceService, objectMapper);
    }
}
