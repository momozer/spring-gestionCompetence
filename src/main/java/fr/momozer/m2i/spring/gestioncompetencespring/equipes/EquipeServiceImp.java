package fr.momozer.m2i.spring.gestioncompetencespring.equipes;

import fr.momozer.m2i.spring.gestioncompetencespring.personnes.NiveauCompetence;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.Personne;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.PersonneService;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.dto.PersonneCompetenceMaxDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipeServiceImp implements EquipeService{

    private static final Logger logger = LoggerFactory.getLogger(EquipeService.class);
    private final EquipeRepository equipeRepository;
    private final PersonneService personneService;

    public EquipeServiceImp(EquipeRepository equipeRepository, PersonneService personneService) {
        this.equipeRepository = equipeRepository;

        this.personneService = personneService;
    }


    @Override
    public List<Equipe> findAll(){
        logger.info("Affichage de toutes des equipes");
        return equipeRepository.findAll();
    }

    @Override
    public Equipe save(Equipe entity) {
        for (Personne membre : entity.getMembres()){
            if (membre.getId() == null){
                this.personneService.save(membre);
            }
        }
        logger.info("Sauvegarde d'une nouvelle equipe: " + entity);
        return equipeRepository.save(entity);
    }

    @Override
    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(()->{
            logger.warn("id invalide : "+ id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        }) ;
    }

    @Override
    public void deleteById(String id) {
        logger.info("Suppression d'une equipe à partir de son id : " + id);
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe ajoutMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        Personne membre = this.personneService.findById(idMembre);
      if(equipe.getMembres().stream().noneMatch(equipeMembre -> equipeMembre.getId().equals(idMembre))){
          equipe.getMembres().add(membre);
      }
      return this.save(equipe);
    }

    @Override
    public void supprimerMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        for (Personne membre : equipe.getMembres())
             {
                 if (idMembre.equals(membre.getId())){
                     equipe.getMembres().remove(membre);
                 break;
                 }
        }
    }

    @Override
    public List<PersonneCompetenceMaxDTO> trouverPersonneCompetenceMax(String idEquipe) {
        Equipe equipe = this.findById(idEquipe);
        List<PersonneCompetenceMaxDTO> result = new ArrayList<>();
        for (Personne personne: equipe.getMembres()) {
            Optional<NiveauCompetence> niveauCompetence = personne.getNiveauCompetences().stream().
                    reduce((comp1, comp2) -> {
                        return comp1.getNiveau() > comp2.getNiveau() ? comp1 : comp2;
                    });
            List<NiveauCompetence> niveauCompetences = new ArrayList<>();
            assert niveauCompetence.orElse(null) != null;
            result.add(new PersonneCompetenceMaxDTO(
                    personne.getId(),
                    personne.getNom(),
                    personne.getPrenom(),
                    niveauCompetence.orElse(null).getCompetence()
            ));
            }
        return result;
    }
}
