import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Tuple {
    int x1, y1, x2, y2;
    public Tuple(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class Main {
    public static final int MAX_M = 5000;
    public static final int MAX_Q = 300000;
    public static final int MAX_N = 2500;

    public static int n, q;
    public static Pair[] points = new Pair[MAX_N];
    public static Tuple[] queries = new Tuple[MAX_Q];

    public static TreeSet<Integer> nums = new TreeSet<>();
    public static HashMap<Integer, Integer> mapper = new HashMap<>();

    public static int[][] prefixSum = new int[MAX_M + 2][MAX_M + 2];

    // x 보다 같거나 큰 최초의 숫자 구한 후
    // 좌표압축 했을 때의 결과를 반환
    public static int getLowerBoundary(int x) {
        if(nums.ceiling(x) != null) {
            return mapper.get(nums.ceiling(x));
        }
        return (int) nums.size() + 1;
    }

    // x 보다 같거나 작은 최초의 숫자 구한 후
    // 좌표압축 했을 때의 결과를 반환
    public static int getUpperBoundary(int x) {
        if(nums.floor(x) != null) {
            return mapper.get(nums.floor(x));
        }
        return 0;
    }

    // (x1, y1), (x2, y2) 직사각형 구간 내의 점의 개수를 반환
    public static int getSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - 
                prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Pair(x, y);
            nums.add(x);
            nums.add(y);
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            queries[i] = new Tuple(x1, y1, x2, y2);
        }

        int cnt = 1;
        for(Integer num : nums) {
            mapper.put(num, cnt);
            cnt++;
        }

        for(int i = 0; i < n; i++) {
            int x = points[i].x;
            int y = points[i].y;

            int newX = mapper.get(x);
            int newY = mapper.get(y);

            prefixSum[newX][newY]++;
        }

        for(int i = 1; i <= cnt; i++) {
            for(int j = 1; j <= cnt; j++) {
                prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            int x1 = queries[i].x1;
            int y1 = queries[i].y1;
            int x2 = queries[i].x2;
            int y2 = queries[i].y2;

            int newX1 = getLowerBoundary(x1);
            int newY1 = getLowerBoundary(y1);
            int newX2 = getUpperBoundary(x2);
            int newY2 = getUpperBoundary(y2);

            int ans = getSum(newX1, newY1, newX2, newY2);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
