package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonneRepository extends MongoRepository<Personne, String>{

    List<Personne> findByNiveauCompetencesCompetenceId(String competenceId);

}
