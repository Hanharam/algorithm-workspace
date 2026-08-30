import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Pair[] pairs = new Pair[n];

        TreeSet<Integer> setX = new TreeSet<>();
        TreeSet<Integer> setY = new TreeSet<>();

        HashMap<Integer, Integer> mapperX = new HashMap<>();
        HashMap<Integer, Integer> mapperY = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pairs[i] = new Pair(x, y);
            
            setX.add(x);
            setY.add(y);
        }

        int cnt = 1;
        for(Integer num : setX) {
            mapperX.put(num, cnt);
            cnt++;
        }

        cnt = 1;
        for(Integer num : setY) {
            mapperY.put(num, cnt);
            cnt++;
        }

        int[][] prefix = new int[setX.size() + 1][setY.size() + 1];

        for(Pair p : pairs) {
            int x = mapperX.get(p.x);
            int y = mapperY.get(p.y);

            prefix[x][y]++;
        }

        for(int i = 1; i <= setX.size(); i++) {
            for(int j = 1; j <= setY.size(); j++) {
                prefix[i][j] += prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            }
        }

        int minX = setX.first();
        int maxX = setX.last();
        int minY = setY.first();
        int maxY = setY.last();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            Integer realX1 = setX.ceiling(Integer.parseInt(st.nextToken()));
            Integer realY1 = setY.ceiling(Integer.parseInt(st.nextToken()));
            Integer realX2 = setX.floor(Integer.parseInt(st.nextToken()));
            Integer realY2 = setY.floor(Integer.parseInt(st.nextToken()));

            if (realX1 == null || realY1 == null ||
                realX2 == null || realY2 == null ||
                realX1 > realX2 || realY1 > realY2) {

                sb.append(0).append('\n');
                continue;
            }
            
            int x1 = mapperX.get(realX1);
            int y1 = mapperY.get(realY1);
            int x2 = mapperX.get(realX2);
            int y2 = mapperY.get(realY2);

            int ans = prefix[x2][y2] - prefix[x2][y1 - 1] - prefix[x1 - 1][y2] + prefix[x1 - 1][y1 - 1];
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
