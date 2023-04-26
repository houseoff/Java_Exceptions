// Запишите в файл следующие строки:
// Анна=4
// Елена=5
// Марина=6
// Владимир=?
// Константин=?
// Иван=4
// Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap)
// В отдельном методе нужно будет пройти по структуре данных, если сохранено значение ?, заменить его на соответствующее число
// Если на каком-то месте встречается символ, отличный от числа или ?, - бросить подходящее исключение
// Записать в тот же файл данные с замененными символами ?

package seminar2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidObjectException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task3 {
    public static void main(String[] args) throws IOException {
        String path = "seminar2/task3_file.txt";
        Map<String, String> read = readFile(path);
        writeFile(read, path);
    }

    public static boolean isMatch(String text, String regex) {
        Pattern pat = Pattern.compile(regex);
        Matcher matcher = pat.matcher(text);
        return matcher.lookingAt();
    }

    public static Map<String, String> readFile(String path) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            Map<String, String> dict = new HashMap<>();
            String line;
            while ((line = bf.readLine()) != null) {
                if (isMatch(line, ".*\\s+.*")) {
                    throw (new InvalidObjectException("Входная строка не должна содержать пробелы"));
                }
                String[] arr = line.split("=");
                for (int i = 0; i < arr.length - 1; i++) {
                    String key = arr[i].toLowerCase().strip();
                    String value = arr[i + 1].toLowerCase().strip();
                    if (!isMatch(key, "[а-яА-Я]")) {
                        throw (new InvalidObjectException("Значение '" + key + "' должно состоять только из букв русского алфавита"));
                    }
                    if (!isMatch(value, "\\?|\\d+")) {
                        throw (new InvalidObjectException("Значение '" + value + "' должно быть либо знаком ?, либо целым числом"));
                    }
                    dict.put(key, value);
                }
            }
            return dict;
        }
    }

    public static void writeFile(Map<String, String> dict, String path) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path), "UTF-8")) {
            for (String key : dict.keySet()) {
                if (isMatch(dict.get(key), "\\?")) {
                    dict.put(key, String.valueOf(key.length()));
                }
                String newLine = String.format("%s=%s\n", key, dict.get(key));
                osw.write(newLine);
            }
        }
    }
}
