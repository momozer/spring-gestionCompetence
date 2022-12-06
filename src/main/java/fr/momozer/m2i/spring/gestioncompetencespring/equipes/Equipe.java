package fr.momozer.m2i.spring.gestioncompetencespring.equipes;

import fr.momozer.m2i.spring.gestioncompetencespring.utils.Entity;
import fr.momozer.m2i.spring.gestioncompetencespring.personnes.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Equipe extends Entity {
    private String nom;

    @DBRef
    private List<Personne> membres = new ArrayList<>();
}
