import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] nums;
    public static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int targetIdx = 0;

        nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(nums[i] == k) targetIdx = i;
        }
        parent = new int[n + 1];

        parent[0] = -1;
        parent[1] = 0;

        int parentIdx = 0;
        for(int i = 2; i <= n; i++) {
            if(nums[i] != nums[i - 1] + 1) parentIdx++;
            
            parent[i] = parentIdx;
        }
            
        int ans = 0;
        if(parent[targetIdx] != 0 && parent[parent[targetIdx]] != 0) {
            int targetParent = parent[targetIdx];
            int targetGrandParent = parent[targetParent];

            for (int i = 1; i <= n; i++) {
                if (parent[parent[i]] == targetGrandParent && parent[i] != targetParent) {
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }
}