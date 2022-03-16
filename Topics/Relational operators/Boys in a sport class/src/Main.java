import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        boolean result1 = a >= b && b >= c;
        boolean result2 = a <= b && b <= c;
        System.out.println(result1 || result2);
    }
}
