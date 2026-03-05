package boj;

//개미 다리 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice {

    // 노드 인덱스 정의
    static int N; // 하우스/급식소 개수
    static int S = 0; // 소스
    static int T; // 싱크
    static final long INF = Long.MAX_VALUE;

    // Dinic 알고리즘에 필요한 변수
    static List<Edge>[] adj;
    static int[] level;

    // Dinic 알고리즘 구현
    static class Edge {
        int to;
        long capacity;
        int reverseIndex;

        public Edge(int to, long capacity, int reverseIndex) {
            this.to = to;
            this.capacity = capacity;
            this.reverseIndex = reverseIndex;
        }
    }

    // BFS로 레벨 그래프 구성
    static boolean bfs(int s, int t) {
        level = new int[T + 1];
        Arrays.fill(level, -1);
        Queue<Integer> q = new LinkedList<>();
        level[s] = 0;
        q.offer(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : adj[u]) {
                if (e.capacity > 0 && level[e.to] < 0) {
                    level[e.to] = level[u] + 1;
                    q.offer(e.to);
                }
            }
        }
        return level[t] != -1;
    }

    // DFS로 유량 흘려보내기
    static long dfs(int u, int t, long pushed, int[] ptr) {
        if (pushed == 0 || u == t) {
            return pushed;
        }

        for (int i = ptr[u]; i < adj[u].size(); i = ptr[u]) {
            Edge e = adj[u].get(i);
            if (level[u] + 1 != level[e.to] || e.capacity == 0) {
                ptr[u]++;
                continue;
            }

            long flow = dfs(e.to, t, Math.min(pushed, e.capacity), ptr);
            if (flow == 0) {
                ptr[u]++;
                continue;
            }

            e.capacity -= flow;
            adj[e.to].get(e.reverseIndex).capacity += flow;
            return flow;
        }
        return 0;
    }

    static long dinic(int s, int t) {
        long flow = 0;
        int[] ptr = new int[T + 1];

        while (bfs(s, t)) {
            Arrays.fill(ptr, 0);
            while (true) {
                long pushed = dfs(s, t, INF, ptr);
                if (pushed == 0) break;
                flow += pushed;
            }
        }
        return flow;
    }

    // 엣지 추가 함수 (역방향 엣지 포함)
    static void addEdge(int u, int v, long capacity) {
        adj[u].add(new Edge(v, capacity, adj[v].size()));
        adj[v].add(new Edge(u, 0, adj[u].size() - 1));
    }

    // 잔여 그래프에서 특정 노드 u가 v로부터 도달 가능한지 확인
    static boolean isReachable(int start, int target) {
        boolean[] visited = new boolean[T + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == target) return true;

            for (Edge e : adj[u]) {
                // 잔여 용량이 남아있는 엣지 (역방향 경로가 존재함)
                if (e.capacity > 0 && !visited[e.to]) {
                    visited[e.to] = true;
                    q.offer(e.to);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // StringTokenizer 추가

        // 입력 1: N N (하우스/급식소 개수) -> StringTokenizer 사용
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // int M_input = Integer.parseInt(st.nextToken()); // 두 번째 N 값은 사용하지 않음

        // 입력 2: M (|E|)
        int M = Integer.parseInt(br.readLine());
        T = 2 * N + 1; // 싱크 인덱스

        // ------------------ 1. 데이터 전처리 및 유량 네트워크 구성 ------------------

        // uniquePairs: 고유한 (u, v) 쌍의 리스트
        // bridgeCounts: 고유한 쌍별 다리 개수
        List<int[]> uniquePairs = new ArrayList<>();
        Map<Long, Integer> bridgeCounts = new HashMap<>();

        // key: (u * (N+1)) + v 로 인코딩하여 (u, v) 쌍을 유니크하게 저장

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); // StringTokenizer 사용
            int u_house = Integer.parseInt(st.nextToken());
            int v_feed = Integer.parseInt(st.nextToken());

            // 노드 매핑: House (1~N) -> 1~N, Feed (1~N) -> N+1~2N
            int u = u_house;
            int v = N + v_feed;

            // 중복 다리 개수 카운트
            long key = (long)u * (N + 1) + v;
            bridgeCounts.put(key, bridgeCounts.getOrDefault(key, 0) + 1);

            // 유니크한 쌍만 저장
            if (bridgeCounts.get(key) == 1) {
                uniquePairs.add(new int[]{u, v});
            }
        }

        // ------------------ 2. Max Flow 계산 ------------------
        adj = new List[T + 1];
        for (int i = 0; i <= T; i++) {
            adj[i] = new ArrayList<>();
        }

        // S -> X (House) 엣지 추가 (용량 1)
        for (int i = 1; i <= N; i++) {
            addEdge(S, i, 1);
        }

        // Y (Feed) -> T 엣지 추가 (용량 1)
        for (int i = N + 1; i <= 2 * N; i++) {
            addEdge(i, T, 1);
        }

        // X -> Y 엣지 추가 (용량 1, 다리가 여러 개여도 용량은 1)
        for (int[] pair : uniquePairs) {
            addEdge(pair[0], pair[1], 1);
        }

        // 최대 유량 실행 (Critical Edge 판별을 위해 잔여 그래프를 만들기 위함)
        dinic(S, T);

        // ------------------ 3. Critical Pair 판별 및 개수 계산 ------------------
        long totalRemovableBridges = 0;

        for (int[] pair : uniquePairs) {
            int u = pair[0];
            int v = pair[1];
            long key = (long)u * (N + 1) + v;
            int count = bridgeCounts.get(key); // 해당 쌍의 총 다리 개수

            // 유량 네트워크에서 u->v 엣지를 찾아 매칭에 사용되었는지 확인
            Edge forwardEdge = null;
            for(Edge e : adj[u]) {
                if(e.to == v) {
                    forwardEdge = e;
                    break;
                }
            }

            // 만약 유량 1로 포화된 엣지라면 (매칭에 사용되었다면)
            if (forwardEdge != null && forwardEdge.capacity == 0) {
                // 잔여 그래프에서 v -> u 경로가 있는지 확인 (교대 순환 가능성 체크)
                if (isReachable(v, u)) {
                    // Non-Critical Pair: 다른 매칭이 존재함. 모든 다리 제거 가능.
                    totalRemovableBridges += count;
                } else {
                    // Critical Pair: 이 쌍은 모든 최대 매칭에 필수적.
                    // 하나만 남기고 나머지는 제거 가능. (count - 1)
                    totalRemovableBridges += (count - 1);
                }
            } else {
                // 유량 0인 엣지: 이 엣지는 현재의 Max Flow에 사용되지 않음.
                // 제거해도 Max Flow는 N으로 유지됨. (Non-Critical). 모든 다리 제거 가능.
                totalRemovableBridges += count;
            }
        }

        // ------------------ 4. 출력 (System.out.println 사용) ------------------
        System.out.println(totalRemovableBridges);
    }
}