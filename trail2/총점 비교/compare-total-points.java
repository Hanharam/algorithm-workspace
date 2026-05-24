import java.util.*;
import java.io.*;


class Student implements Comparable<Student> {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {
        return (this.kor + this.eng + this.math) - (student.kor + student.eng + student.math);
    }
};

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken())
                , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students);

        for(int i = 0; i < n; i++) {
            System.out.println(students[i].name + " " + students[i].kor + " " 
                + students[i].eng + " " + students[i].math);
        }

    }
}

