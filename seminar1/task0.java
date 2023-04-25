// Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
// Если длни массива меньше некоторого заданного минимума, 
// метод возвращает -1 в качестве ошибки, иначе - длину массива
package seminar1;

public class task0 {
    
    public static void main(String[] args) {
        int[] array = null;
        System.out.println(arrayLength(array));
    }

    public static int arrayLength(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }

        return array.length;
    }

}
