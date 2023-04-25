// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен сумме элементов двух входящих массивов в той же ячейке
// Если длины массивов не равны, необходимо как-то оповестить пользователя

package seminar1;

public class task7 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        printArray(newArrayFromSum(arr1, arr2));
    }

    public static int[] newArrayFromSum(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw (new RuntimeException("Длины массивов должны быть одинаковыми"));
        }
        
        int[] resultArray = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            resultArray[i] = arr1[i] + arr2[i];
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
