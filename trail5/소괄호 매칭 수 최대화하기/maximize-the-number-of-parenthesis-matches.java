import java.util.*;
import java.io.*;

class Block implements Comparable<Block>{
    int l, r;

    public Block(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Block b) {
        return Long.compare((long) b.l * this.r, (long) this.l * b.r);
    }
}

public class Main {
    public static int n;
    public static Block[] blocks;
    public static char[][] sentences;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        blocks = new Block[n];
        sentences = new char[n][];

        for(int i = 0; i < n; i++) {
            sentences[i] = br.readLine().toCharArray();

            int lCnt = 0;
            int rCnt = 0;
            for(char c : sentences[i]) {
                if(c == '(') lCnt++;
                else if(c == ')') rCnt++;
            }

            blocks[i] = new Block(lCnt, rCnt);
        }

        Arrays.sort(blocks);

        long answer = 0;

        for(int i = 0; i < n; i++) {
            int lCnt = 0;
            long sum = 0;
            for(char c : sentences[i]) {
                if(c == '(') lCnt++;
                else if(c == ')') sum += lCnt;
            }
            answer += sum;
        }

        long totalCnt = 0;
        for(int i = 0; i < n; i++) {
            Block b = blocks[i];

            answer += totalCnt * b.r;
            totalCnt += b.l;
        }
        System.out.print(answer);
    }
}