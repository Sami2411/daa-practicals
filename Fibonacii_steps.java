import java.util.*;

public class Fibonacii_steps {

    static int recursive_steps = 0;
    static int nonrecur_steps = 0;

    // Recursive Fibonacci function
    public static int recursiveFunction(int n) {
        recursive_steps++;
        if (n <= 1) {
            return n;
        }
        return recursiveFunction(n - 1) + recursiveFunction(n - 2);
    }

    // Non-recursive (Iterative) Fibonacci function
    public static int nonRecursive(int n) {
        if (n <= 1) {
            nonrecur_steps++;
            return n;
        }

        int prev = 0, curr = 1;
        nonrecur_steps += 2; // initialization steps

        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
            nonrecur_steps++;
        }
        return curr;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the index: ");
        int n = s.nextInt();
        s.close();

        int rec_result = recursiveFunction(n);
        int nonrec_result = nonRecursive(n);

        System.out.println("\nFibonacci number at index " + n + " (Recursive): " + rec_result);
        System.out.println("Recursive Steps: " + recursive_steps);

        System.out.println("\nFibonacci number at index " + n + " (Non-Recursive): " + nonrec_result);
        System.out.println("Non-Recursive Steps: " + nonrecur_steps);
    }
}
