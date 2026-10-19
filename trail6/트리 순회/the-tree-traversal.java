import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static char[] left = new char[26];
    public static char[] right = new char[26];

    public static void preOrder(char node) {
        if(node == '.') return;

        System.out.print(node);
        preOrder(left[node - 'A']);
        preOrder(right[node - 'A']);

    }

    public static void inOrder(char node) {
        if(node == '.') return;

        inOrder(left[node - 'A']);
        System.out.print(node);
        inOrder(right[node - 'A']);
    }

    public static void postOrder(char node) {
        if(node == '.') return;

        postOrder(left[node - 'A']);
        postOrder(right[node - 'A']);
        System.out.print(node);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftNode = st.nextToken().charAt(0);
            char rightNode = st.nextToken().charAt(0);

            int index = parent - 'A';

            left[index] = leftNode;
            right[index] = rightNode;
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
    }
}