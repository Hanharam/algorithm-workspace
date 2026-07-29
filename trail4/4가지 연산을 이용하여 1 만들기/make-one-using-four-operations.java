import java.io.*;
import java.util.*;


class Info {
    int num, cnt;

    public Info(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {
    public static int n;
    public static Queue<Info> q = new LinkedList<>(); // idx, 몇번했는지 
    public static ArrayList<Integer> arr = new ArrayList<>(); // 실제 값 보관


    public static int calc(int curNum, int i) {
        switch(i) {
            case 1:
                return curNum + 1;
            case 2:
                return curNum / 2;
            case 3:
                return curNum / 3;
            case 4:
                return curNum - 1; 
        }
        return 0;
    }

    public static void bfs() {
        boolean[] visited = new boolean[1000005];

        visited[n] = true;
        q.add(new Info(n, 0));

        while(!q.isEmpty()) {
            Info f = q.poll();
            int cnt = f.cnt;
            int curNum = f.num;

            if(curNum == 1) {
                System.out.print(cnt);
                return;
            }

            int[] nextNums = {
                curNum - 1, 
                curNum + 1, 
                (curNum % 2 == 0) ? curNum / 2 : -1, 
                (curNum % 3 == 0) ? curNum / 3 : -1
            };

            for(int i = 0; i < 4; i++) {
                int next = nextNums[i];

                if (next >= 1 && next < visited.length && !visited[next]) {
                    visited[next] = true;
                    q.add(new Info(next, cnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        bfs();
    }
}