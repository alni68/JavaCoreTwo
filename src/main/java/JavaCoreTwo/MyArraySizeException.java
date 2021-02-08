package JavaCoreTwo;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Некорректна размерность массива");
    }
}
