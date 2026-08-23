import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
    int o, a, t;

    public Person(int o, int a, int t) {
        this.o = o;
        this.a = a;
        this.t = t;
    }

    @Override
    public int compareTo(Person p) {
        if(a != p.a) return a - p.a;
        else return o - p.o;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Person> pq = new PriorityQueue<>();
        PriorityQueue<Integer> wait = new PriorityQueue<>();

        int[] arrival = new int[n + 1];
        int[] time = new int[n + 1];

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arrival[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
            pq.add(new Person(i, arrival[i], time[i]));
        }

        int totalTime = 0;
        int ans = 0;
        while(!pq.isEmpty() || !wait.isEmpty()) {
            
            if(wait.isEmpty()) {
                wait.add(pq.poll().o);
            }

            while(!pq.isEmpty()) {
                Person p = pq.peek();
                if(p.a <= totalTime) {
                    pq.poll();
                    wait.add(p.o);
                } else break;
            }
            

            int order = wait.poll();
            if(totalTime < arrival[order]) totalTime = arrival[order] + time[order];
            else {
                ans = Math.max(ans, totalTime - arrival[order]);
                totalTime += time[order];
            }
        }

        System.out.print(ans);
    }
}