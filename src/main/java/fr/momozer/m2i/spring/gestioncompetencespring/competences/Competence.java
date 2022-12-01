package fr.momozer.m2i.spring.gestioncompetencespring.competences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Competence {
    @Id
    private String id;
    private String nom;
    private String description;

}
