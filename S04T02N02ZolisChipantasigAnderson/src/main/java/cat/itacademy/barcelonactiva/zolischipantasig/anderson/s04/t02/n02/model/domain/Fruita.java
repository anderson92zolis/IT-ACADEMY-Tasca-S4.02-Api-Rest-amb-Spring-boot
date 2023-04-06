package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.lang.Object;

@Entity
@Table(name = "fruita")
public class Fruita implements Serializable {

    /*
    Entity: Package where the class that represents the database table is created.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "quantitatQuilos")
    private int quantitatQuilos;


    public Fruita (){}

    public Fruita(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }

    //Setters


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
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
