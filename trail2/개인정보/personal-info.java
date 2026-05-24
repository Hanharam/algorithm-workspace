import java.util.*;
import java.io.*;

class Person {
    String name;
    int height; 
    float weight;

    public Person(String name, int height, float weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Person[] people = new Person[5];

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Float.parseFloat(st.nextToken()));
        }

        Arrays.sort(people, (a, b) -> a.name.compareTo(b.name));
        System.out.println("name");
        for(int i = 0; i < 5; i++) {
            System.out.println(people[i].name + " " + people[i].height + " " + people[i].weight);
        }

        Arrays.sort(people, (a, b) -> b.height - a.height);
        System.out.println("\nheight");
        for(int i = 0; i < 5; i++) {
            System.out.println(people[i].name + " " + people[i].height + " " + people[i].weight);
        }

    }
}