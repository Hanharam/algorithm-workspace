import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 1987654321;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        int[][] dp = new int[n + 1][m + 1];
        Pair[][] path = new Pair[n + 1][m + 1];
        int[][] curBest = new int[n + 1][m + 1];

        a.add(0);
        b.add(0);

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            b.add(Integer.parseInt(st.nextToken()));
            
        }

        Collections.reverse(a.subList(1, n + 1));
        Collections.reverse(b.subList(1, m + 1));

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                curBest[i][j] = INF;
                path[i][j] = new Pair(0, 0);
            }
        }
        curBest[0][0] = 0;

        // dp[i][j] == 문자열 a는 i 번째까지, 문자열 b는 j번째까지 보았을 때 최장 공통 부분 수열의 길이
        // cur_best[i][j] == 문자열 a는 i번째까지, 문자열 b는 j번째까지 보았을 때 최장 공통 부분 수열 중
        // 가장 마지막으로 선택된 값을 최소화 시킨 수열의 그 최솟값
        // path[i][j] == 그러한 최장 공통 부분 수열이 어느 이전 정보에서 왔는지의 정보
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                // 각 단계에서 최적의 해를 찾는다.
                // 현재 dp[i][j]에 저장된 후보보다 위쪽 상태 dp[i - 1][j]가 더 좋은가?
                // 최장 길이가 더 긴 것 선택, 길이가 같다면 curBest가 작은 값 선택
                if(dp[i - 1][j] > dp[i][j] || (dp[i - 1][j] == dp[i][j] && curBest[i - 1][j] < curBest[i][j])) {
                    dp[i][j] = dp[i - 1][j];
                    path[i][j] = new Pair(i - 1, j);
                    curBest[i][j] = curBest[i - 1][j];
                }

                if(dp[i][j - 1] > dp[i][j] || (dp[i][j - 1] == dp[i][j]) && curBest[i][j - 1] < curBest[i][j]) {
                    dp[i][j] = dp[i][j - 1];
                    path[i][j] = new Pair(i, j - 1);
                    curBest[i][j] = curBest[i][j - 1];
                }

                if(a.get(i).equals(b.get(j)) && (dp[i - 1][j - 1] + 1 > dp[i][j] || (dp[i - 1][j - 1] == dp[i][j] && a.get(i) < curBest[i][j]))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    path[i][j] = new Pair(i - 1, j - 1);
                    curBest[i][j] = a.get(i);
                }
            }
        }

        // 최장 공콩 부분 수열 추적
        ArrayList<Integer> lcs = new ArrayList<>();
        for (int i = n, j = m; i > 0 && j > 0;) {
            if(path[i][j].equals(new Pair(i - 1, j - 1)) && a.get(i).equals(b.get(j))) {
                lcs.add(a.get(i));
                i--; j--;
            } else {
                Pair p = path[i][j];
                i = p.x;
                j = p.y;
            }
        }

        // 최장 공통 부분 수열 출력
        for(int i = 0; i < lcs.size(); i++) {
            System.out.print(lcs.get(i) + " ");
        }
        System.out.println();
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
    }
}