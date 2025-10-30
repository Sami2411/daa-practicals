import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;
}

public class Huffman {
    // Function to print Huffman Codes
    static void printCodes(Node root, String code) {
        if (root == null)
            return;

        // If leaf node → print character and code
        if (root.left == null && root.right == null)
            System.out.println(root.ch + " : " + code);

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        // Example data
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freq = { 5, 9, 12, 13, 16, 45 };
        int n = chars.length;

        // Min-heap based on frequency
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));

        // Create leaf nodes and add to queue
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.ch = chars[i];
            node.freq = freq[i];
            q.add(node);
        }

        // Build Huffman Tree
        while (q.size() > 1) {
            Node left = q.poll();
            Node right = q.poll();

            Node newNode = new Node();
            newNode.freq = left.freq + right.freq;
            newNode.ch = '-';
            newNode.left = left;
            newNode.right = right;

            q.add(newNode);
        }

        // Root of Huffman Tree
        Node root = q.peek();

        System.out.println("Character : Huffman Code");
        printCodes(root, "");
    }
}

