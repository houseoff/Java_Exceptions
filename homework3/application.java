package homework3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.time.DateTimeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class application {

    static Map<Integer, String> errMsg = new HashMap<>() {{
        put(1, "Входная строка не может быть пустой");
        put(2, "Введенные данные не совпадают по количеству");
        put(3, "Неверный формат даты");
        put(4, "Неверный формат строки");
        put(5, "Неверный формат номера телефона");
        put(6, "Неверный формат поля \"Пол\"");
    }};

    public static String inputData() {
        Scanner scanner = new Scanner(System.in, "Cp866");
        System.out.println("Введите данные в следующем порядке через пробел");
        System.out.print("Фамилия Имя Отчество Дата_рождения Номер_телефона Пол: ");
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static String parseDate(String input) throws Exception {
        String[] inputArray = input.split("\\.");
        String msg = null;
        boolean exceptionFlag = false;

        if (inputArray.length != 3) {
            msg = String.format("%s: необходимый формат \"ДД.ММ.ГГГГ\"", errMsg.get(3));
            throw new DateTimeException(msg);
        }

        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                if (!(inputArray[i].matches("^\\d{4}$"))) {
                    msg = String.format("%s: год должен состоять из 4 цифр", errMsg.get(3));
                    throw new DateTimeException(msg);
                }
            } else {
                if (!(inputArray[i].matches("^\\d{2}$"))) {
                    msg = String.format("%s: день и месяц должны состоять из 2 цифр", errMsg.get(3));
                    throw new DateTimeException(msg);
                }
            }
        }

        Integer d = Integer.parseInt(inputArray[0]);
        Integer m = Integer.parseInt(inputArray[1]);
        Integer y = Integer.parseInt(inputArray[2]);

        if (y < 2024 && y > 1899) {
            if (m > 0 && m < 13) {
                if (d > 0 && d < 32) {
                    if (m == 2 && d == 29 && !((y % 100 != 0 && y % 4 == 0) || y % 400 == 0)) {
                        msg = String.format("%s: в феврале не может быть 29 дней, если год не високосный", errMsg.get(3));
                        exceptionFlag = true;
                    } else if (m == 2 && d > 29) {
                        msg = String.format("%s: в феврале не может быть больше 29 дней", errMsg.get(3));
                        exceptionFlag = true;
                    } else if (inputArray[1].matches("^(04|06|09|11)$") && d == 31) {
                        msg = String.format("%s: в %d месяце не может быть 31 день", errMsg.get(3), m);
                        exceptionFlag = true;
                    }
                } else {
                    msg = String.format("%s: \"%d\" дня не существует", errMsg.get(3), d);
                    exceptionFlag = true;
                }
            } else {
                msg = String.format("%s: \"%d\" месяца не существует", errMsg.get(3), m);
                exceptionFlag = true;
            }
        } else {
            msg = String.format("%s: год должен быть в диапазоне от 1900 до 2023 включительно", errMsg.get(3));
            exceptionFlag = true;
        }

        if (exceptionFlag) {
            throw new DateTimeException(msg);
        }

        return input;
    }

    public static Map<Integer, String> parseInput(String input) throws Exception {
        String msg = null;

        if (input.matches("^\\s+$") || input.equals("")) {
            throw new NullPointerException(errMsg.get(1));
        }
        
        String[] inputArray = input.split(" ");

        if (inputArray.length != 6) {
            throw new ParseException(errMsg.get(2), 1);
        }

        for (int i = 0; i < 3; i++) {
            if (!inputArray[i].matches("^[А-Я,а-я,A-Z,a-z]*$")) {
                msg = String.format("%s: ФИО должно состоять только из букв русского или английского алфавита", errMsg.get(4));
                throw new ParseException(msg, 1);
            }
        }

        parseDate(inputArray[3]);

        if (!inputArray[4].matches("^8\\d+$") || inputArray[4].length() != 11) {
            msg = String.format("%s: номер телефона должен начинаться с 8 и состоять из 11 цифр", errMsg.get(5));
            throw new ParseException(msg, 1);
        }

        if (!inputArray[5].matches("^[fm]$") || inputArray[5].length() != 1) {
            msg = String.format("%s: поле должно содержать либо \"f\" либо \"m\"", errMsg.get(6));
            throw new ParseException(msg, 1);
        }

        Map<Integer, String> dict = new HashMap<>(){{
            put(1, inputArray[0]);
            put(2, inputArray[1]);
            put(3, inputArray[2]);
            put(4, inputArray[3]);
            put(5, inputArray[4]);
            put(6, inputArray[5]);
        }};

        return dict;
    }

    public static void writeFile(Map<Integer, String> dict) {
        String fileName = dict.get(1) + ".txt";
        File file = new File(fileName);
        try (
            FileOutputStream fos   = new FileOutputStream(file, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8")
        ) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < 7; i++) {
                sb.append("<");
                sb.append(dict.get(i));
                sb.append(">");
            }
            osw.write(sb.toString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            writeFile(parseInput(inputData()));
        } catch (DateTimeException | NullPointerException | ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
