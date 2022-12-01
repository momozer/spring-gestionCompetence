package fr.momozer.m2i.spring.gestioncompetencespring.competences;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompetenceConfiguration {

    @Bean
    public CompetenceService competenceService(CompetenceRepository competenceRepository){
        return new CompetenceServiceImpl(competenceRepository);
    }
}
