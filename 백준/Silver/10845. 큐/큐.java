
import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] queue = new int[N];
        int front = 0;
        int rear = 0;

        StringBuilder out = new StringBuilder();
        StringTokenizer st;

        for(int i = 0; i < N; i++){

            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd){

                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue[rear++] = x;
                    break;

                case "pop":
                    if(front == rear) out.append(-1);
                    else out.append(queue[front++]);
                    out.append("\n");
                    break;

                case "size":
                    out.append(rear - front).append("\n");
                    break;

                case "empty":
                    if(front == rear) out.append(1);
                    else out.append(0);
                    out.append("\n");
                    break;

                case "front":
                    if(front == rear) out.append(-1);
                    else out.append(queue[front]);
                    out.append("\n");
                    break;

                case "back":
                    if(front == rear) out.append(-1);
                    else out.append(queue[rear - 1]);
                    out.append("\n");
                    break;
            }
        }

        System.out.print(out);
    }
}