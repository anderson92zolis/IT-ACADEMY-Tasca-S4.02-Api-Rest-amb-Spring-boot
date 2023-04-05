package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto;

/**
 * Package where the classes are created that are limited to being data transfer objects between the client and the server.
 */
public class Message {

    private String messageBody;

    public Message (String message) {
        this.messageBody = message;
    }

    public String getMessage() {
        return messageBody;
    }

    public void setMessage(String message) {
        this.messageBody = message;
    }
}