import java.io.*;
import java.util.*;

public class Main {
    public static int[] x;
    public static int[] y;

    public static int calculate(int i, int j, int k) {
        if(x[i] == x[j] && y[i] == y[k]) {
            return Math.abs(y[i] - y[j]) * Math.abs(x[i] - x[k]);
        }
        else if(y[i] == y[j] && x[i] == x[k]) {
            return Math.abs(x[i] - x[j]) * Math.abs(y[i] - y[k]);
        }
        else if(x[j] == x[i] && y[j] == y[k]) {
            return Math.abs(x[j] - x[j]) * Math.abs(y[j] - y[i]);
        }
        else if(y[j] == y[i] && x[j] == x[k]) {
            return Math.abs(x[j] - x[i]) * Math.abs(y[j] - y[k]);
        }
        else if(x[k] == x[i] && y[k] == y[j]) {
            return Math.abs(x[k] - x[j]) * Math.abs(y[k] - y[i]);
        }
        else if(y[k] == y[i] && x[k] == x[j]) {
            return Math.abs(x[i] - x[k]) * Math.abs(y[j] - y[k]);
        }
        else return 0;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        x = new int[n];
        y = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    answer = Math.max(answer, calculate(i, j, k));
                }
            }
        }
        System.out.print(answer);
    }
}
