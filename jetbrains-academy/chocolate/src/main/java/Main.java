import java.util.Scanner;

class Main {

    public static boolean isPossible(int n, int m, int k) {
        final int total = m * n;
        for (int i = total; i > 0; i -= n) {
            if (i == k) {
                return true;
            }
        }
        for (int i = (total - m); i > 0; i -= m) {
            if (i == k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        if (isPossible(n, m, k)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}
