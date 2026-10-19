import java.util.*;
import java.io.*;

public class Main {
    public static int k;
    public static int[] tree;
    public static ArrayList<Integer>[] levels; 

    public static void parse(int start, int end, int depth) {
        if(start > end) return;

        int mid = (start + end) / 2;
        levels[depth].add(tree[mid]);
        
        parse(start, mid - 1, depth + 1);
        parse(mid + 1, end, depth + 1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        int count = (int) Math.pow(2, k) - 1;
        tree = new int[count + 1];

        levels = new ArrayList[k + 1];
        for(int i = 0; i <= k; i++) {
            levels[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++) {
            int num = Integer.parseInt(st.nextToken());
            tree[i] = num;
        }

        parse(0, count - 1, 1);

        for(int i = 1; i <= k; i++) {
            for(int num : levels[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}