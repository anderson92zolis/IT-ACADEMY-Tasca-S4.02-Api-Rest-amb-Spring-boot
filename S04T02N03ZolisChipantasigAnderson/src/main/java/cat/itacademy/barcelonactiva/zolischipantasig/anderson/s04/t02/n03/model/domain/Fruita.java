package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.domain;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;


import java.lang.Object;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "fruita")
public class Fruita {

    /*
    Entity: Package where the class that represents the database table is created.
     */

    @Id
    private int id;
    private String nom;
    private int quantitatQuilos;
}