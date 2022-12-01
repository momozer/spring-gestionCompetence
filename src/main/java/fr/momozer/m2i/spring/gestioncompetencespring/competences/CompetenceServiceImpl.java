package fr.momozer.m2i.spring.gestioncompetencespring.competences;

import fr.momozer.m2i.spring.gestioncompetencespring.personnes.Personne;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.PersonneRepository;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository competenceRepository;

    public CompetenceServiceImpl(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    @Override
    public List<Competence> findAll() {
        return competenceRepository.findAll();
    }

    @Override
    public Competence save(Competence entity) {
        return competenceRepository.save(entity);
    }

    @Override
    public Competence findById(String id) {
        return competenceRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        competenceRepository.deleteById(id);
    }
}
