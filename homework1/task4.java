// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива и возвращающий новый массив,
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке
// Если длины массивов не равны, то необходимо оповестить пользователя
// Важно: при выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException

package homework1;

public class task4 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 0};
        int[] arr2 = {1, 2, 0, 0, 5};
        printArray(newArrayFromDiv(arr1, arr2));
    }

    public static int[] newArrayFromDiv(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw (new RuntimeException("Длины массивов должны быть одинаковыми"));
        }
        
        int[] resultArray = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            try {
                resultArray[i] = arr1[i] / arr2[i];
            } catch (ArithmeticException e) {
                resultArray[i] = 0;
            }
        }

        return resultArray;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
