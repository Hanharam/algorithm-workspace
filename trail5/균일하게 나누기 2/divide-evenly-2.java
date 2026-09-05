import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(x != p.x) return this.x - p.x;
        return this.y - p.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] pairs = new Pair[n];

        TreeSet<Integer> posX = new TreeSet<>();
        TreeSet<Integer> posY = new TreeSet<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            posX.add(x);
            posY.add(y);

            pairs[i] = (new Pair(x, y));
        }

        HashMap<Integer, Integer> mapperX = new HashMap<>();
        HashMap<Integer, Integer> mapperY = new HashMap<>();

        int idx = 1;
        for(int num : posX) {
            mapperX.put(num, idx);
            idx++;
        }

        idx = 1;
        for(int num : posY) {
            mapperY.put(num, idx);
            idx++;
        }

        int xSize = posX.size();
        int ySize = posY.size();

        int[][] grid = new int[xSize + 1][ySize + 1];
        for(Pair p : pairs) {
            int cx = mapperX.get(p.x);
            int cy = mapperY.get(p.y);

            grid[cx][cy]++;
        }

        int[][] prefixSum = new int[xSize + 1][ySize + 1];
        for(int i = 1; i <= xSize; i++) {
            for(int j = 1; j <= ySize; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + grid[i][j];
            }
        }

        int ans = n;
        for(int xCut = 0; xCut <= xSize; xCut++) {
            for(int yCut = 0; yCut <= ySize; yCut++) {
                int leftBottom = prefixSum[xCut][yCut];

                int leftTop = prefixSum[xCut][ySize] - leftBottom;
                int rightBottom = prefixSum[xSize][yCut] - leftBottom;
                int rightTop = prefixSum[xSize][ySize] - leftTop - rightBottom - leftBottom;

                int max = Math.max(
                    Math.max(leftBottom, leftTop),
                    Math.max(rightBottom, rightTop)
                );

                ans = Math.min(ans, max);
            }
        }        
        System.out.print(ans);
    }
}