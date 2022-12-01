package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import java.util.List;

public interface PersonneService {
    List<Personne> findAll();

    Personne save(Personne entity);

    Personne findById(String id);

    void deleteById(String id);
}
