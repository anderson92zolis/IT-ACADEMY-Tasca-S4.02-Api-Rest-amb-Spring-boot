package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Annotations

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@Document(collection = "fruita")
public class Fruita {
    @Id
    private int id;
    private String nom;
    private int quantitatQuilos;

    public Fruita(int id, String nom, int quantitatQuilos) {
        this.id = id;
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }


    @Override
    public String toString() {
        return "Fruita{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantitatQuilos=" + quantitatQuilos +
                '}';
    }
}