package JavaCoreTwo;

public class DZ2 {


    public static void main(String[] args) {
        int result=0;

        String[][] array={
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"8", "7", "6", "5"},
                {"4", "3", "2", "1"}
        };
        String[][] error_array={
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8", "9"},
                {"8", "7", "6", "5"},
                {"4", "3", "2", "1"}
        };
        String[][] error_data={
                {"1", "2", "3", "4"},
                {"5", "6", "!", "8"},
                {"8", "7", "6", "5"},
                {"4", "#", "2", "1"}
        };

        System.out.println(" ");

        System.out.println("(Корректный массив размерностью 4х4)");
        try {
            result=0;
            result=analyze(array);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Сумма элементов массива равна " + String.valueOf(result));
            System.out.println(" ");
        }

        System.out.println("(Массив с нарушенной размерностью 4х4)");
        try {
            result=0;
            result=analyze(error_array);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
//            System.out.println("Сумма элементов массива равна " + String.valueOf(result));
            System.out.println(" ");
        }

        System.out.println("(Массив с нарушенным форматом элементов)");
        try {
            result=0;
            result=analyze(error_data);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
//            System.out.println("Сумма элементов массива равна " + String.valueOf(result));
        }
    }

    public static int analyze(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int summ=0;
        int value=0;
        int row=0;
        int col=0;

        if (array.length != 4 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }

        for (int i=1; i < 5; i++) {
            row=i;
            for (int j=1; j < 5; j++) {
                col=j;
                try {
                    value=Integer.parseInt(array[i - 1][j - 1]);
                    summ+=value;
                } catch (IllegalArgumentException e) {
                    String message="в " + String.valueOf(row) + " ряду, " + String.valueOf(col) + " колонке";
                    throw new MyArrayDataException(message);
                }

            }
        }
        return summ;
    }
}