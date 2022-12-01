package fr.momozer.m2i.spring.gestioncompetencespring.equipes;

import fr.momozer.m2i.spring.gestioncompetencespring.personnes.Personne;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/equipes")
public class EquipeController {
    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }
    @GetMapping("")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }
    @PostMapping("")
    public Equipe save(Equipe entity) {
        return equipeService.save(entity);
    }
    @GetMapping("{id}")
    public Equipe findById(String id) {
        return equipeService.findById(id);
    }
    @DeleteMapping("{id}")
    public void deleteById(String id) {
        equipeService.deleteById(id);
    }
}
