package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n01;

public class Fruita {
    private int id;
    private String nom;
    private int quantitatQuilos;

    public Fruita(int id, String nom, int quantitatQuilos) {
        this.id = id;
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
