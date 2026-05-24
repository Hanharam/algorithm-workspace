import java.io.*;
import java.util.*;

class Seq implements Comparable<Seq>{
    int length;
    int idx;

    public Seq(int length, int idx) {
        this.length = length;
        this.idx = idx;
    }

    @Override
    public int compareTo(Seq seq) {
        if(this.length == seq.length) {
            return this.idx - seq.idx;
        }
        return this.length - seq.length;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] answer = new int[n];

        Seq[] seqs = new Seq[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while(st.hasMoreTokens()) {
            seqs[idx] = new Seq(Integer.parseInt(st.nextToken()), idx++);
        }

        Arrays.sort(seqs);

        for(int i = 0; i < n; i++) {
            answer[seqs[i].idx] = i + 1;
        }


        for(int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
        
    }
}