// Разработайте программу, которая выбросит исключение, когда пользователь введёт пустую строку
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя
package homework2;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String s = sc.nextLine();
        if (s.length() == 0) {
            sc.close();
            throw (new RuntimeException("Пустые строки вводить запрещено"));
        }
        sc.close();
    }
}
