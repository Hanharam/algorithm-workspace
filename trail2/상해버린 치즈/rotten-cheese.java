import java.io.*;
import java.util.*;

public class Main {
    public static class Person {
        int m;
        int eat;
        int sick;
    }
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] eatP = new int[d];
        int[] eatM = new int[d];
        int[] eatT = new int[d];

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            eatP[i] = Integer.parseInt(st.nextToken());
            eatM[i] = Integer.parseInt(st.nextToken());
            eatT[i] = Integer.parseInt(st.nextToken());
        }

        int[] sickP = new int[s];
        int[] sickT = new int[s];

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            sickP[i] = Integer.parseInt(st.nextToken());
            sickT[i] = Integer.parseInt(st.nextToken());
        }

        int maxPills = Integer.MIN_VALUE;

        for(int cheese = 1; cheese <= m; cheese++) {
            boolean isSpoiled = true;

            for(int i = 0; i < s; i++) {
                int person = sickP[i];
                int time = sickT[i];
                
                boolean beforeSick = false;
                for(int j = 0; j < d; j++) {
                    if(eatP[j] == person && time > eatT[j] && eatM[j] == cheese) {
                        beforeSick = true;
                        break;
                    }
                }
                if(!beforeSick) {
                    isSpoiled = false;
                    break;
                }
            }

            if(isSpoiled) {
                boolean[] hasEaten = new boolean[n + 1];

                int pillCount = 0;
                for(int j = 0; j < d; j++) {
                    if(eatM[j] == cheese && !hasEaten[eatP[j]]) {
                        hasEaten[eatP[j]] = true;
                        pillCount++;
                    }
                }

                maxPills = Math.max(maxPills, pillCount);
            }
        }
        System.out.print(maxPills);
    }
}