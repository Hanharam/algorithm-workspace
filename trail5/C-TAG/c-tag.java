import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] a = new char[n][m];
        char[][] b = new char[n][m];

        for(int i = 0; i < n; i++) {
            a[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            b[i] = br.readLine().toCharArray();
        }
        
        int ans = 0;

        for(int i = 0; i < m; i++) {
            for(int j = i + 1; j < m; j++) {
                for(int k = j + 1; k < m; k++) {

                    HashSet<String> s = new HashSet<>();

                    for(int e = 0; e < n; e++) {
                        String key = "" + a[e][i] + a[e][j] + a[e][k];
                        s.add(key);
                    }

                    boolean possible = true;

                    for(int e = 0; e < n; e++) {
                        String key = "" + b[e][i] + b[e][j] + b[e][k];

                        if(s.contains(key)) {
                            possible = false;
                            break;
                        }
                    }

                    if(possible) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}