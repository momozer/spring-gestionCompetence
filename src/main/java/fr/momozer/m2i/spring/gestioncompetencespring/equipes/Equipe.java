package fr.momozer.m2i.spring.gestioncompetencespring.equipes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    private String id;
    private String nom;
}
