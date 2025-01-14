public class exp1 {
    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (i < 2) {
                return false;
            }
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            if (isPrime(j)) {
                System.out.print(j);
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}