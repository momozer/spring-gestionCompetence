package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import fr.momozer.m2i.spring.gestioncompetencespring.competences.Competence;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.dto.PersonneMinimalDTO;

import java.util.List;

public interface PersonneService {
    List<PersonneMinimalDTO> findAll();

    /**
     * Enregistrer une entity de type Personne.
     * @param entity qui est une nouvelle personne de type Personne
     * @return nouvelle personne
     */
    Personne save(Personne entity);

    /**
     * Trouver une personne en focntion de son Id
     * @param id de la personne
     * @return
     */
    Personne findById(String id);

    /**
     * Ajouter  un niveau de competence à un personne ou le Modifier
     * @param idPersonne
     * @param idCompetence
     * @param niveau
     * @return une personne avec un niveau de competence et sa competence
     */
    Personne addOrUpdateNiveauCompetence(String idPersonne, String idCompetence, Integer niveau );


    /**
     * Supprimer une competence d'une personne
     * @param idPersonne
     * @param idCompetence
     * @return
     */
    Personne deleteNiveauCompetence(String idPersonne, String idCompetence);


    /**
     * Supprimer une personne par rapport à son Id
     * @param id de la personne
     */
    void deleteById(String id);

    /**
     * Retourne la liste des personnes possédant la compétence
     * @param idCompetence
     * @param niveau
     * @return
     */
    List<Personne> rechercherPersonneParCompetenceSupA(String idCompetence, Integer niveau);
}
