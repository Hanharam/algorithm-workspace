import java.util.*;
import java.io.*;

class Person implements Comparable<Person> {
    long start, end;

    public Person(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Person p) {
        return Long.compare(p.start, start);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet<Long> s = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        Person[] people = new Person[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            long start = Long.parseLong(st.nextToken());
            long speed = Long.parseLong(st.nextToken());

            long end = start + speed * t;
            people[i] = new Person(start, end);
        }

        Arrays.sort(people);

        long next = Long.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            Person p = people[i];

            long pos = Math.min(p.end, next);
            Long group = s.floor(pos);

            if(group == null) {
                next = pos;
                s.add(pos);
            }
        }

        System.out.print(s.size());
    }
}