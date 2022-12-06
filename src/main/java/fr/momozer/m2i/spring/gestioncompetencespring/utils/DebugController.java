package fr.momozer.m2i.spring.gestioncompetencespring.utils;

import fr.momozer.m2i.spring.gestioncompetencespring.competences.Competence;
import fr.momozer.m2i.spring.gestioncompetencespring.competences.CompetenceRepository;
import fr.momozer.m2i.spring.gestioncompetencespring.equipes.EquipeRepository;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.PersonneRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("debug")
@Profile("dev")
public class DebugController {
    private final CompetenceRepository competenceRepository;
    private final PersonneRepository personneRepository;
    private final EquipeRepository equipeRepository;

    public DebugController(CompetenceRepository competenceRepository, PersonneRepository personneRepository, EquipeRepository equipeRepository) {
        this.competenceRepository = competenceRepository;
        this.personneRepository = personneRepository;
        this.equipeRepository = equipeRepository;
    }

    @DeleteMapping("clear")
    public void clear(){
        competenceRepository.deleteAll();;
        personneRepository.deleteAll();
        equipeRepository.deleteAll();
    }

    @PostMapping("init")
    public void inti(){
        clear();
        Competence java = this.competenceRepository.save(new Competence("Java", "Un langage de programmation objet"));
    }
}
