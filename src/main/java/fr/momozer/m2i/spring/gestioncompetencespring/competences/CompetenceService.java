package fr.momozer.m2i.spring.gestioncompetencespring.competences;

import fr.momozer.m2i.spring.gestioncompetencespring.personnes.Personne;

import java.util.List;

public interface CompetenceService {

    List<Competence> findAll();

    Competence save(Competence entity);

    Competence findById(String id);

    void deleteById(String id);
}
