package StudentDatabaseApp;

import java.util.Scanner;

public class StudentAppMain {

    static Scanner input = new Scanner(System.in);
    private static Student[] students;

    public static void main(String[] args) {

        int numOfNewStudents;

        System.out.println("Welcome to the Student Database");
        System.out.println("How many students would you like to add?");
        numOfNewStudents = input.nextInt();
        students = new Student[numOfNewStudents];

        for(int i = 0; i < numOfNewStudents; i++) {
            System.out.print("\n");
            System.out.println("Student: " + (i + 1));
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            System.out.print("\n");
            System.out.println(students[i]);
        }




    }
}
