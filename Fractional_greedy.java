
import java.util.*;

public class fractional_greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight of item " + (i + 1) + ": ");
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        // Store items as [value, weight, ratio]
        double[][] items = new double[n][3];
        for (int i = 0; i < n; i++) {
            items[i][0] = value[i];
            items[i][1] = weight[i];
            items[i][2] = value[i] / (double) weight[i];
        }

        // Sort by ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));

        double totalValue = 0;
        int currWeight = 0;

        System.out.println("\nValue\tWeight\tTaken");
        for (double[] it : items) {
            if (currWeight + it[1] <= capacity) {
                currWeight += it[1];
                totalValue += it[0];
                System.out.println((int) it[0] + "\t" + (int) it[1] + "\tFull");
            } else {
                int remain = capacity - currWeight;
                double frac = remain / it[1];
                totalValue += it[0] * frac;
                System.out.println((int) it[0] + "\t" + (int) it[1] + "\t" + String.format("%.2f%%", frac * 100));
                break;
            }
        }

        System.out.println("\nMaximum value in Knapsack = " + totalValue);
        sc.close();
    }
}
