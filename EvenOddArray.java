package studyopedia;

import java.util.Scanner;

public class EvenOddArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();


        int[] even = new int[n];
        int[] odd = new int[n];


        int evenIndex = 0;
        int oddIndex = 0;


        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int num = scanner.nextInt();

            if (num % 2 == 0) {
                even[evenIndex++] = num;
            } else {
                odd[oddIndex++] = num;
            }
        }


        System.out.println("Even numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }


        System.out.println("\nOdd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        scanner.close();
    }
}
