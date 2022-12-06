package fr.momozer.m2i.spring.gestioncompetencespring.utils;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class Entity {
    @Id
    protected String id;
    protected LocalDateTime dateCreation = LocalDateTime.now();
    protected LocalDateTime dateModification = LocalDateTime.now();
}
