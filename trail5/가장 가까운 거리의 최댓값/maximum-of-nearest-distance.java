import java.util.*;
import java.io.*;

class Node {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
}

class Element implements Comparable<Element>{
    int index, dist;

    public Element(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Element e) {
        return this.index - e.index;
    }
}

public class Main {
    public static int n, m;
    public static int[] num = new int[3];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        int[][] dist = new int[3][n + 1];

        for(int i = 0; i < 3; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();
        for(int i = 0; i < 3; i++) {
            dist[i][num[i]] = 0;
        }

        for(int i = 0; i < 3; i++) {
            pq.add(new Element(num[i], 0));

            while(!pq.isEmpty()) {
                int minIndex = pq.peek().index;
                int minDist = pq.peek().dist;
                pq.poll();

                if(minDist != dist[i][minIndex]) continue;

                for(int j = 0; j < graph[minIndex].size(); j++) {
                    int targetIndex = graph[minIndex].get(j).index;
                    int targetDist = graph[minIndex].get(j).dist;

                    int newDist = dist[i][minIndex] + targetDist;

                    if(dist[i][targetIndex] > newDist) {
                        dist[i][targetIndex] = newDist;
                        pq.add(new Element(targetIndex, newDist));
                    }
                }
            }
        }

        // for(int i = 0; i < 3; i++) {
        //     for(int j = 1; j <= n; j++) {
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < 3; j++) {
                min = Math.min(dist[j][i], min);
            }
            ans = Math.max(ans, min);
        }

        System.out.print(ans);
    }
}