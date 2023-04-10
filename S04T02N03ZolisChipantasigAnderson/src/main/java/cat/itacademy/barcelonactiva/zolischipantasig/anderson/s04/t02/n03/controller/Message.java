package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.controller;



public class Message {

    public static String retrieveAllFruit() {
        return "Retrieving all fruit from the database";
    }

    public static String retrieveAllFruitError() {
        return "No fruit found in the database";
    }

    public static String retrieveFruitById(int id) {
        return "Retrieving fruit with id: " + id;
    }

    public static String retrieveFruitByIdError(int id) {
        return "Fruit with id " + id + " not found in the database";
    }

    public static String createFruit(String nom, int quantitatQuilos) {
        return "Creating fruit with name: " + nom + ", quantity Kg: " + quantitatQuilos;
    }

    public static String createFruitError(String nom) {
        return "Failed to create fruit with name: " + nom;
    }

    public static String updateFruit(int id, String name, int quantitatQuilos) {
        return "Updating fruit with id: " + id + ", name: " + name + ", quantity Kg: " + quantitatQuilos;
    }

    public static String updateFruitError(int id) {
        return "Failed to update fruit with id: " + id;
    }

    public static String deleteFruit(int id) {
        return "Deleting fruit with id: " + id;
    }
}

