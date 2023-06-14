package homework3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class application {

    static Map<Integer, String> errMsg = new HashMap<>() {{
        put(1, "Входная строка не может быть пустой");
        put(2, "Введенные данные не совпадают по количеству");
        put(3, "Неверный формат даты");
        put(4, "Неверный формат строки");
    }};

    public static String inputData() {
        Scanner scanner = new Scanner(System.in, "Cp1251");
        System.out.println("Введите данные в следующем порядке через пробел");
        System.out.print("Фамилия Имя Отчество Дата_рождения Номер_телефона Пол: ");
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public Date parseDate(String input) throws Exception {
        String[] inputArray = input.split(" ");

        if (inputArray.length != 3) {
            String msg = String.format("%s: необходимый формат \"ДД.ММ.ГГГГ\"", errMsg.get(3));
            throw new ParseException(msg, 1);
        }

        for (String string : inputArray) {
            try {
                Integer.parseInt(string);
            } catch (Exception e) {
                String msg = String.format("%s: нечисловое значение \"%s\"", errMsg.get(3), string);
                throw new ParseException(msg, 0);
            }
        }

        Integer day   = Integer.parseInt(inputArray[0]);
        Integer month = Integer.parseInt(inputArray[1]);
        Integer year  = Integer.parseInt(inputArray[2]);

        


    }

    public static String[] parseInput(String input) throws Exception {
        Map<String, String> dict = new HashMap<>(){{
            put("surname",    null);
            put("name",       null);
            put("secondname", null);
            put("birthday",   null);
            put("phone",      null);
            put("sex",        null);
        }};

        if (input.matches("^\\s+$") || input.equals("")) {
            throw new NullPointerException(errMsg.get(1));
        }
        
        String[] inputArray = input.split(" ");

        if (inputArray.length != dict.size()) {
            throw new ParseException(errMsg.get(2), 1);
        }

        for (int i = 0; i < 3; i++) {
            if (!inputArray[i].matches("^[А-Я,а-я,A-Z,a-z]*$")) {
                String msg = String.format("%s: ФИО должно состоять только из букв русского или английского алфавита", errMsg.get(4));
                throw new ParseException(msg, 1);
            }
        }

        return inputArray;
    }

    public static void main(String[] args) throws Exception {
        printArray(parseInput(inputData()));
    }

    private static void printArray(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i]);
            System.out.print(", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.print("]");
        System.out.println();
    }

}
