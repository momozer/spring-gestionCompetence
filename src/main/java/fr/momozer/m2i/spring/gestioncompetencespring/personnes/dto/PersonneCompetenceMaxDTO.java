package fr.momozer.m2i.spring.gestioncompetencespring.personnes.dto;

import fr.momozer.m2i.spring.gestioncompetencespring.competences.Competence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneCompetenceMaxDTO {
    private String id;
    private String nom, prenom;
    private Competence competenceMax;
}
