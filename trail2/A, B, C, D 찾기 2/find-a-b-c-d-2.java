import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[15];

        for(int i = 0; i < 15; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        for(int i = 0; i < 15; i++) {
            for(int j = i + 1; j < 15; j++) {
                for(int k = j + 1; k < 15; k++) {
                    for(int l = k + 1; l < 15; l++) {
                        int a = arr[i];
                        int b = arr[j];
                        int c = arr[k];
                        int d = arr[l];

                        int[] cal = new int[15];

                        cal[0] = a;
                        cal[1] = b;
                        cal[2] = c;
                        cal[3] = d;
                        cal[4] = a + b;
                        cal[5] = b + c;
                        cal[6] = c + d;
                        cal[7] = d + a;
                        cal[8] = a + c;
                        cal[9] = b + d;
                        cal[10] = a + b + c;
                        cal[11] = a + b + d;
                        cal[12] = a + c + d;
                        cal[13] = b + c + d;
                        cal[14] = a + b + c + d;

                        Arrays.sort(cal);

                        if(Arrays.equals(cal, arr)) {
                            System.out.print(a + " " + b + " " + c + " " + d);
                            return;
                        }
                    }
                }
            }
        }
    }
}