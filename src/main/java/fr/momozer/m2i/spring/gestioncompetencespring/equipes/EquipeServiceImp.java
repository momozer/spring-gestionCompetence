package fr.momozer.m2i.spring.gestioncompetencespring.equipes;

import fr.momozer.m2i.spring.gestioncompetencespring.personnes.Personne;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.PersonneService;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipeServiceImp implements EquipeService{
    private final EquipeRepository equipeRepository;
    private final PersonneService personneService;

    public EquipeServiceImp(EquipeRepository equipeRepository, PersonneService personneService) {
        this.equipeRepository = equipeRepository;

        this.personneService = personneService;
    }


    @Override
    public List<Equipe> findAll(){
        return equipeRepository.findAll();
    }

    @Override
    public Equipe save(Equipe entity) {
        for (Personne membre : entity.getMembres()){
            if (membre.getId() == null){
                this.personneService.save(membre);
            }
        }
        return equipeRepository.save(entity);
    }

    @Override
    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
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
}
