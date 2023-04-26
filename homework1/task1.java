// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
package homework1;

public class task1 {
    public static void main(String[] args) {
        demoException1();
        demoException2();
        demoException3();
    }

    public static int demoException1() {
        return 1 / 0;
    }

    public static int demoException2() {
        // String str = null;
        // return str.length();
        return 0;
    }

    public static int demoException3() {
        int[] array = {1, 2, 3, 4, 5};
        return array[10];
    }
}
