import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        boolean[] person = new boolean[n];

        int[] c = new int[m];
        int[] u = new int[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            c[i] = st.nextToken().charAt(0) - 'A';
            u[i] = Integer.parseInt(st.nextToken());
        }

        if(u[p-1] == 0) {
            return;
        }

        for(int i = 0; i < p - 1; i++) {
            if(u[i] == u[p-1]) person[c[i]] = true;
        }

        for(int i = p-1; i < m; i++) {
            person[c[i]] = true;
        }

        for(int i = 0; i < n; i++) {
            char ch = (char)('A' + i);
            if(!person[i]) System.out.print(ch + " ");
        }
    }
}

// 뒤에서 보낸 거 아니면 다 의심 가능
// 해당 메시지 읽은 수와 그 전에 읽을 수와 같으면 그 사람도 읽음
