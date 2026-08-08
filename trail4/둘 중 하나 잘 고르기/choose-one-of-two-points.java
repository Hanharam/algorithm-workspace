import java.io.*;
import java.util.*;

// Greedy
// 2 * n 개의 빨간색 카드 중 n 개의 카드를 파란색으로 교체하는 로직
// red - blue 내림차순으로 정렬 후 앞에서 red 카드 n 개 뒤에서 blue 카드 n개 뽑기
class Card implements Comparable<Card>{
    int red, blue;

    public Card(int red, int blue) {
        this.red = red;
        this.blue = blue;
    }

    @Override
    public int compareTo(Card card) { // 내림차순으로 정렬
        return (card.red - card.blue) - (this.red - this.blue);
    }
}

public class Main {
    public static int n;
    public static Card[] cards = new Card[201];

    public static int[][] dp = new int[201][201]; // red, blue

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < 2 * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            cards[i] = new Card(red, blue);
        }

        Arrays.sort(cards, 0, 2*n);

        int answer = 0;

        for(int i = 0; i < n; i++) {
            answer += cards[i].red;
        }

        for(int i = n; i < 2*n; i++) {
            answer += cards[i].blue;
        }

        System.out.print(answer);
    }
}