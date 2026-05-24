import java.io.*;
import java.util.*;

class Secret {
    String code;
    char place;
    int time;

    public Secret(String code, char place, int time) {
        this.code = code;
        this.place = place;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String code = st.nextToken();
        char place = st.nextToken().charAt(0);
        int time = Integer.parseInt(st.nextToken());

        
        Secret s1 = new Secret(code, place, time);

        System.out.println("secret code : " + s1.code);
        System.out.println("meeting point : " + s1.place);
        System.out.println("time : " + s1.time);

    }
}