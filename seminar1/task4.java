// Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив
// Метод должен пройтись по каждому элементу и проверить что он не равен null
// А теперь реализуйте следующую логику:
// - если в какой-то ячейке встретился null, то необходимо "оповестить" об этом пользователя
// - если null’ы встретились в нескольких ячейках, то идеально было бы все их "подсветить"

package seminar1;

public class task4 {
    public static void main(String[] args) {
        String[] array = {null, null, "121", null, "1234"};
        countNull(array);
    }

    public static void countNull(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                count++;
                System.out.println("Найден null в позиции " + i);
            }
        }
        System.out.println("Общее кол-во null-значений: " + count);
    }
}
