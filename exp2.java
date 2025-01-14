
import java.util.Scanner;

public class exp2 {
    static int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        System.out.print("Enter 10 numbers: ");
        int[] arr = new int[10];
        try (Scanner s = new Scanner(System.in)) {
            for (int i = 0; i < 10; i++) {
                arr[i] = s.nextInt();
            }
        }
        int l = max(arr);
        System.out.print("Largest element in the array is ");
        System.out.println(l);
    }
}
