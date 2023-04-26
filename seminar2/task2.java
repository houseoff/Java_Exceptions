package seminar2;

public class task2 {
    public static void main(String[] args) {
        String[][] arr = {{"1", null},{"123", "x"}};
        System.out.println(sum2d(arr));
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                } catch (NumberFormatException e) {
                    sum += 0;
                }
            }
        }

        return sum;

    }
}
