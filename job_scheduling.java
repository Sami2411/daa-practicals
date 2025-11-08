import java.util.*;

public class job_scheduling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        char jobs[] = new char[n];
        int deadline[] = new int[n];
        int profit[] = new int[n];

        // Taking input from user
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Job " + (i + 1) + ":");
            System.out.print("Job ID (single letter): ");
            jobs[i] = sc.next().charAt(0);
            System.out.print("Deadline: ");
            deadline[i] = sc.nextInt();
            System.out.print("Profit: ");
            profit[i] = sc.nextInt();
        }

        sc.close();

        // Sort jobs by profit in descending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (profit[i] < profit[j]) {
                    int temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;

                    int t2 = deadline[i];
                    deadline[i] = deadline[j];
                    deadline[j] = t2;

                    char t3 = jobs[i];
                    jobs[i] = jobs[j];
                    jobs[j] = t3;
                }
            }
        }

        // Find maximum deadline
        int maxDeadline = 0;
        for (int d : deadline) {
            if (d > maxDeadline)
                maxDeadline = d;
        }

        char result[] = new char[maxDeadline];
        boolean slot[] = new boolean[maxDeadline];

        // Job sequencing
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline, deadline[i]) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = jobs[i];
                    break;
                }
            }
        }

        // Display result
        System.out.println("\nJob sequence for maximum profit:");
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i])
                System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
