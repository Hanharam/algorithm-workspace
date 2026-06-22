import java.io.*;
import java.util.*;


public class Main {
    public static class Person implements Comparable<Person>{
    int pos;
    char type;

    public Person(int pos, char type) {
        this.pos = pos;
        this.type = type;
    }

    @Override
    public int compareTo(Person person) {
        return this.pos - person.pos;
    }
}
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] person = new Person[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            
            person[i] = new Person(pos, c);
        }  

        Arrays.sort(person);

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int numG = 0;
                int numH = 0;

                for(int k = i; k <= j; k++) {
                    if(person[k].type == 'G') numG++;
                    else numH++;
                }

                if(numG == numH || numG == 0 || numH == 0) {
                    max = Math.max(person[j].pos - person[i].pos, max);
                }
            }
        }

        System.out.print(max);
    }
}