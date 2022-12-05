package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.momozer.m2i.spring.gestioncompetencespring.competences.Competence;
import fr.momozer.m2i.spring.gestioncompetencespring.competences.CompetenceService;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.dto.PersonneMinimalDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class PersonneServiceImpl implements PersonneService {
    private final PersonneRepository personneRepository;
    private final CompetenceService competenceService;
    private final ObjectMapper objectMapper;

    public PersonneServiceImpl(PersonneRepository personneRepository,  CompetenceService competenceService, ObjectMapper objectMapper) {
        this.personneRepository = personneRepository;
        this.competenceService = competenceService;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<PersonneMinimalDTO> findAll() {
        List<Personne> listePersonnes = personneRepository.findAll(PageRequest.of(0, 10)).toList();
        return this.objectMapper.convertValue(
                listePersonnes,
                new TypeReference<List<PersonneMinimalDTO>>(){}
                );
    }
    @Override
    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    @Override
    public Personne findById(String id) {
        return personneRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Personne addNiveauCompetence(String idPersonne, String idCompetence, Integer niveau) {
        Personne personne = this.findById(idPersonne);
        Competence competence = this.competenceService.findById(idCompetence);
        NiveauCompetence niveauCompetence = new NiveauCompetence(competence, niveau);
        personne.getNiveauCompetences().add(niveauCompetence);
        return this.save(personne);
    }

    @Override
    public Personne updateNiveauCompetence(String idPersonne, String idCompetence, Integer niveau) {
        Personne personne = this.findById(idPersonne);
        List<NiveauCompetence> liste = personne.getNiveauCompetences();
        List<NiveauCompetence> listeNouvelle = new ArrayList<>();
        for (NiveauCompetence niveauCompet : liste) {
            if(niveauCompet.getCompetence().getId().equals(idCompetence) ) {
                niveauCompet.setNiveau(niveau);
            }
            listeNouvelle.add(niveauCompet);
        }
        personne.setNiveauCompetences(listeNouvelle);
        return this.save(personne);

    }


    @Override
    public void deleteById(String id) {
        personneRepository.deleteById(id);
    }
}
