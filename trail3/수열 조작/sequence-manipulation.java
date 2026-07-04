import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        while(dq.size() > 1) {
            dq.pollFirst();
            dq.addLast(dq.peekFirst());
            dq.pollFirst();
        }

        System.out.print(dq.pollFirst());
    }
}