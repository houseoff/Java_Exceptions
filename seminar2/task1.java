package seminar2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.print("Укажите индекс элемента массива, в который хотите записать значение 1: ");
        try {
            int index = scanner.nextInt();
            arr[index] = 1;
        } catch (InputMismatchException e) {
            System.out.println("Введено некорректное значение");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Указан индекс за пределами массива");
        }
        finally {
            scanner.close();
        }
    }
}
