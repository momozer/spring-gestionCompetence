package fr.momozer.m2i.spring.gestioncompetencespring.competences;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetenceRepository extends MongoRepository<Competence, String> {
}
