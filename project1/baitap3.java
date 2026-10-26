import java.util.Scanner;

public class baitap3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Số phần tử: 0; Tổng: 0");
            scanner.close();
            return;
        }

        String[] parts = input.split("\\s+");
        long sum = 0;

        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        System.out.println("Số phần tử: " + parts.length + "; Tổng: " + sum);
        scanner.close();
    }
}
