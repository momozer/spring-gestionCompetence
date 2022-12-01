package fr.momozer.m2i.spring.gestioncompetencespring.equipes;

import fr.momozer.m2i.spring.gestioncompetencespring.personnes.Personne;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipeServiceImp implements EquipeService{
    private final EquipeRepository equipeRepository;

    public EquipeServiceImp(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @Override
    public List<Equipe> findAll(){
        return equipeRepository.findAll();
    }

    @Override
    public Equipe save(Equipe entity) {
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
}
