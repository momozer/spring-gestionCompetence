package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonneRepository extends MongoRepository<Personne, String> {
}
