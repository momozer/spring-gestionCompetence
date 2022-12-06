package fr.momozer.m2i.spring.gestioncompetencespring.personnes;

import fr.momozer.m2i.spring.gestioncompetencespring.utils.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Personne extends Entity {
    private String nom;
    private String prenom;


    private List<NiveauCompetence> niveauCompetences = new ArrayList<>();

}
