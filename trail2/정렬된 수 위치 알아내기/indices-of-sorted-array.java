import java.io.*;
import java.util.*;

class Seq implements Comparable<Seq>{
    int length, number;
    int sortedNumber;

    public Seq(int length, int number) {
        this.length = length;
        this.number = number;
    }

    @Override
    public int compareTo(Seq seq) {
        if(this.length == seq.length) {
            return this.number - seq.number;
        }
        return this.length - seq.length;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Seq[] seqs = new Seq[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while(st.hasMoreTokens()) {
            seqs[idx] = new Seq(Integer.parseInt(st.nextToken()), ++idx);
        }

        Arrays.sort(seqs);

        for(int i = 0; i < n; i++) {
            seqs[i].sortedNumber = i + 1;
        }

        Arrays.sort(seqs, (a, b) -> a.number - b.number);

        for(int i = 0; i < n; i++) {
            System.out.print(seqs[i].sortedNumber + " ");
        }
        
    }
}