package fr.momozer.m2i.spring.gestioncompetencespring.equipes;

import fr.momozer.m2i.spring.gestioncompetencespring.personnes.Personne;

import java.util.List;

public interface EquipeService {
    List<Equipe> findAll();

    Equipe save(Equipe entity);

    Equipe findById(String id);

    void deleteById(String id);

    /**
     * Ajoute un membre (idMembre) à une équipe (idEquipe)
     * @param idEquipe id de l'équipe
     * @param idMembre id de la personne
     * @return l'équipe avec les membres
     */
    Equipe ajoutMembre(String idEquipe, String idMembre);

    /**
     * Supprime un membre (idMembre) à une équipe (idEquipe)
     * @param idEquipe  id de l'équipe
     * @param idMembre id de la personne
     */
    void supprimerMembre(String idEquipe, String idMembre);
}
