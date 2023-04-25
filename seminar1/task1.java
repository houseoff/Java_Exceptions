// Реализуйте метод, принимающий в качестве аргумента целочисленный массив, и некоторое значение
// Метод ищет в массиве заданное значение и возвращает его индекс
// При этом, если длина массива меньше некоторого заданного минимума, метод возвращает -1
// Если искомый элемент не найден, метод вернет -2
// Если вместо массива пришёл null - метод вернет -3
// 
// Напишите метод, в котором реализуйте взаимодействие с пользователем.
// Этот метод запросит искомое число у пользователя, вызовет метод выше,
// обработает возвращенное значение и покажет читаемый результат пользователю

package seminar1;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class task1 {
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int result = findElement(array, intInput());
        if (result < 0) {
            getError(result);
        }
        else {
            System.out.println("Найденная позиция: " + result);
        }
    }

    public static void getError(int code) {
        Dictionary<Integer, String> dict = new Hashtable<>();
        dict.put(1, "Длина массива не может быть меньше 1");
        dict.put(2, "Искомый элемент не найден");
        dict.put(3, "Невозможно вызвать метод для выражения со значением null");

        System.out.println(dict.get(-code));
    }

    public static int findElement(int[] array, int searched) {
        if (array == null) {
            return -3;
        }

        if (array.length < 1) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (searched == array[i]) {
                return i;
            }
        }

        return -2;
    }

    public static int intInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int result = scan.nextInt();
        scan.close();
        return result;
    }

}
