package Exeptions;

public class Exceptions extends RuntimeException {
    private String message;

    public Exceptions(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "exeption " + message;
    }
}
