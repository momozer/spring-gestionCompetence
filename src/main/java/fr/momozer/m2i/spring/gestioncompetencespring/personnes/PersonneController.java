package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import fr.momozer.m2i.spring.gestioncompetencespring.competences.Competence;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.dto.PersonneMinimalDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnes")
public class PersonneController {
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }
    @GetMapping("")
    public List<PersonneMinimalDTO> findAll() {
        return personneService.findAll();
    }
    @PostMapping("")
    public Personne save(@RequestBody Personne entity) {
        return personneService.save(entity);
    }
    @GetMapping("{id}")
    public Personne findById(@PathVariable String id) {
        return personneService.findById(id);
    }

    @PostMapping("{idPersonne}/competences/{idCompetence}")
    public Personne addNiveauCompetence(@PathVariable String idPersonne,
                                        @PathVariable String idCompetence,
                                        @RequestParam Integer niveaucompetence){
        return personneService.addNiveauCompetence(idPersonne, idCompetence, niveaucompetence);
    }

    @PutMapping("{idPersonne}/competences/{idCompetence}")
    public Personne updateNiveauCompetence(@PathVariable String idPersonne,
                                           @PathVariable String idCompetence,
                                           @RequestParam Integer niveaucompetence){
        return personneService.updateNiveauCompetence(idPersonne,  idCompetence,  niveaucompetence);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        personneService.deleteById(id);
    }
}
