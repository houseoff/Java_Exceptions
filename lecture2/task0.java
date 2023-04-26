// Обработка исключений try-catch
public class task0 {

    public static void main(String[] args) {
        int number = 1;
        try {
            number = 10 / 0;
            // String string = null;
            // System.out.println(string.length());
        }
        catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        }
        catch (NullPointerException e) {
            System.out.println("Невозможно вызвать метод для выражения со значением null");
        }
        catch (Exception e) {
            System.out.println("Неопознанная ошибка");
        }
        System.out.println(number);
        
    }
}