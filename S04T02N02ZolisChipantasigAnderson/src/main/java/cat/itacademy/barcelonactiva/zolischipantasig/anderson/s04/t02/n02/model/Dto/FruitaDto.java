package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto;

/**
 * Data transfer object between the client and the server.
 */


public class FruitaDto {

    private String nom;

    private int quantitatQuilos;

    public FruitaDto() {
    }

    public FruitaDto(String nom, int quantitatQuilos) {
        this.nom = nom;

        this.quantitatQuilos = quantitatQuilos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantityKg() {
        return quantitatQuilos;
    }

    public void setQuantityKg(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }

    @Override
    public String toString() {
        return "FruitDto{" +
                "nom='" + nom + '\'' +
                ", quantitatQuilos=" + quantitatQuilos +
                '}';
    }
}
