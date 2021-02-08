package JavaCoreTwo;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super("Формат данных нарушен "+message);
    }
}