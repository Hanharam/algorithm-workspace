import java.util.*;
import java.io.*;

public class Main {
    public static int n, q;
    public static int[] arr = new int[100002];

    public static TreeSet<Integer> nums = new TreeSet<>();
    public static HashMap<Integer, Integer> mapper = new HashMap<>();

    public static int[] prefixSum = new int[100002];

    public static int getLowerBound(int x) {
        if(nums.ceiling(x) != null) return mapper.get(nums.ceiling(x));
        return nums.size() + 1;
    }

    public static int getUpperBound(int x) {
        if(nums.floor(x) != null) return mapper.get(nums.floor(x));
        return 0;
    }

    public static int getSum(int a, int b) {
        return prefixSum[b] - prefixSum[a - 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            nums.add(arr[i]);
        }
        
        int cnt = 1;
        for(Integer num : nums) {
            mapper.put(num, cnt);
            prefixSum[cnt]++;
            cnt++;
        }

        for(int i = 1; i <= n; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int newA = getLowerBound(a);
            int newB = getUpperBound(b);

            int ans = getSum(newA, newB);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}