import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static Line[] lines;

    public static int[] correct;

    public static int[] current;

    public static int answer;

    static class Line {
        int left;
        int height;

        Line(int left, int height) {
            this.left = left;
            this.height = height;
        }
    }

    public static void swap(int[] arr, int left) {
        int temp = arr[left];
        arr[left] = arr[left + 1];
        arr[left + 1] = temp;
    }

    static void findMin(int index, int used) {
        if(used >= answer) {
            return;
        }

        if(index == m) {
            if(Arrays.equals(current, correct)) {
                answer = used;
            }
            return;
        }

        findMin(index + 1, used);

        int left = lines[index].left;

        swap(current, left);
        findMin(index + 1, used + 1);
        swap(current, left);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lines = new Line[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[i] = new Line(a, b);
        }

        Arrays.sort(lines, Comparator.comparingInt(line -> line.height));

        correct = new int[n + 1];
        current = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            correct[i] = i;
            current[i] = i;
        }

        for(Line line : lines) {
            swap(correct, line.left);
        }

        answer = m;

        findMin(0, 0);

        System.out.println(answer);
    }
}