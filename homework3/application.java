package homework3;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class application {

    static Map<Integer, String> errorMessage = new HashMap<>() {{
        put(1, "Входная строка не может быть пустой");
        put(2, "Введенные данные не совпадают по количеству");
    }};

    public static String inputData() {
        Scanner scanner = new Scanner(System.in, "Cp866");
        System.out.println("Введите данные в следующем порядке");
        System.out.print("Фамилия Имя Отчество Дата_рождения Номер_телефона Пол: ");
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static String parseInput(String input) {

        Map<String, String> dict = new HashMap<>(){{
            put("surname",    null);
            put("name",       null);
            put("secondname", null);
            put("birthday",   null);
            put("phone",      null);
            put("sex",        null);
        }};

        if (input.matches("^\\s+$") || input.equals("")) {
            throw new NullPointerException(errorMessage.get(1));
        }

        String[] inputArray = input.split(" ");

        if (inputArray.length != dict.size()) {
            throw new InputMismatchException(errorMessage.get(2));
        }

        return input;
    }

    public static void main(String[] args) {
        System.out.println(parseInput(inputData()));
    }

}
