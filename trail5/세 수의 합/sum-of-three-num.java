import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> m = new HashMap<>();

        int[] arr = new int[n];

        int ans = 0;

        // 각 숫자가 몇 번 나왔는 지 기록
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        // 배열을 순회하며 쌍을 만들어줌
        for(int i = 0; i < n; i++) {
            // 이미 순회한 적이 있으면 숫자를 빼기
            // 같은 조합 방지
            if(!m.containsKey(arr[i]))
                m.put(arr[i], - 1);
            else
                m.put(arr[i], m.get(arr[i]) - 1);

            for(int j = 0; j < i; j++) {
                if(m.containsKey(k - arr[i] - arr[j]))
                    ans += m.get(k - arr[i] - arr[j]);
            }
        }

        System.out.print(ans);
    }
}