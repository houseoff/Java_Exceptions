// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив
// Необходимо посчитать и вернуть сумму элементов этого массива
// При этом накладываем на метод 2 ограничения: 
// - метод может работать только с квадратными массивами, и в каждой ячейке может лежать только значение 0 или 1
// - если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке

package seminar1;

public class task2 {
    public static void main(String[] args) {
        int[][] array = {{1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 6}};
        System.out.println(sumArray(array));
    }

    public static int sumArray(int[][] array) {
        if (array.length == array[0].length) {
            for (int i = 1; i < array.length; i++) {
                if (array[0].length != array[i].length) {
                    throw new RuntimeException("Массив должен быть квадратным");
                }
            }

            int summ = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i][j] > 1 || array[i][j] < 0) {
                        throw new RuntimeException("В массиве должны содержаться только значения 0 и 1");
                    }
                    summ += array[i][j];
                }
            }
            return summ;
        }
        else {
            throw new RuntimeException("Массив должен быть квадратным");
        }
    }
}
