import java.util.*;

class Item {
    int weight;
    int value;
    double ratio;  // value/weight ratio
}

public class practical3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        // Taking user input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight of item " + (i + 1) + ": ");
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        // Creating item list
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Item it = new Item();
            it.value = value[i];
            it.weight = weight[i];
            it.ratio = (double) it.value / it.weight;
            items.add(it);
        }

        // Sort items by ratio (value/weight) descending
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int currentWeight = 0;

        System.out.println("\nItems taken in knapsack:");
        System.out.println("Value\tWeight\tTaken");

        for (Item it : items) {
            if (currentWeight + it.weight <= capacity) {
                currentWeight += it.weight;
                totalValue += it.value;
                System.out.println(it.value + "\t" + it.weight + "\tFull");
            } else {
                int remain = capacity - currentWeight;
                double fraction = (double) remain / it.weight;
                totalValue += it.value * fraction;
                System.out.println(it.value + "\t" + it.weight + "\t" + String.format("%.2f", fraction * 100) + "%");
                break;
            }
        }

        System.out.println("\nMaximum value in Knapsack = " + totalValue);
        sc.close();
    }
}
