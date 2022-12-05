package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import fr.momozer.m2i.spring.gestioncompetencespring.competences.Competence;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.dto.PersonneMinimalDTO;

import java.util.List;

public interface PersonneService {
    List<PersonneMinimalDTO> findAll();

    Personne save(Personne entity);

    Personne findById(String id);

    Personne addNiveauCompetence(String idPersonne, String idCompetence, Integer Niveau );

    Personne updateNiveauCompetence(NiveauCompetence niveauCompetence);

    void deleteById(String id);
}
