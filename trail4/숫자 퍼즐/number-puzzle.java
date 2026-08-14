import java.io.*;
import java.util.*;

// K번째 찾기
// = 작은 숫자부터 선택해보고
//   그 숫자 아래 정답 개수를 확인해서
//   K가 그 안에 있으면 내려가고,
//   아니면 그 개수만큼 K에서 빼고 다음 숫자로 넘어간다.
public class Main {
    public static int n, m;
    public static long k;
    public static long[][][] dp;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // dp[cnt][sum][minVal]
        dp = new long[n + 1][m + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        List<Integer> answer = new ArrayList<>();

        // 처음에는 숫자 n개를 전부 골라야하고 합은 m, 첫 숫자는 1
        int remainCnt = n;
        int remainSum = m;
        int minVal = 1;


        // 앞자리부터 하나씩 정답을 결정함
        while(remainCnt > 0) {
            for(int x = minVal; x <= remainSum; x++) {

                // 현재 자리에 x를 넣었을 때, 뒤에 만들 수 있는 정답 수열의 개수 구하기
                long cnt = count(remainCnt - 1, remainSum - x, x);

                // K보다 cnt 값이 크면 k번째 수열은 이 그룹안에 속해 있음
                // 그래서 현재 숫자를 정답에 넣고 다음 자리로 이동
                if(k <= cnt) {
                    answer.add(x);

                    remainCnt--;
                    remainSum -= x;
                    minVal = x;

                    break;
                } else {
                    k -= cnt;
                }
            }
        }

        for(int i = 0; i < answer.size(); i++) {
            if(i > 0) System.out.print(" ");
            System.out.print(answer.get(i));
        }
    }


    // 앞으로 cnt 개의 숫자를 더 골라야 하고,
    // 그 숫자들의 합이 sum 이어야 하며,
    // 다음에 고를 숫자가 최소 minVal 이상일 때
    // 만들 수 있는 수열의 개수
    public static long count(int cnt, int sum, int minVal) {

        // 숫자를 더 이상 고를 필요가 없는데 sum도 0이면 딱 맞게 완성
        // 가능한 방법 1개 추가
        if(cnt == 0) {
            return sum == 0 ? 1 : 0;
        }
        
        // 남은 합이 음수가 되면 불가능
        if(sum < 0) {
            return 0;
        }

        // 앞으로 고를 숫자는 minVal 이상이므로
        // 최소 합보다 남은 합이 더 커야함
        if((long) minVal * cnt > sum) {
            return 0;
        }

        // Memorization
        if(dp[cnt][sum][minVal] != -1) {
            return dp[cnt][sum][minVal];
        }


        // 점화식
        long result = 0;

        for(int x = minVal; x <= sum; x++) {
            result += count(cnt - 1, sum - x, x);

            if(result > 1_000_000_000L) {
                result = 1_000_000_000L;
                break;
            }
        }

        return dp[cnt][sum][minVal] = result;
    }
}