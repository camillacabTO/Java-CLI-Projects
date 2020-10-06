package StudentDatabaseApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentId;
    double balance = 0;
    private ArrayList<String> coursesEnrolled = new ArrayList<String>();
    private static String[] coursesAvailable = {"History 101", "Mathematics 101", "English 101",
            "Chemistry 101", "Computer Science 101"};
    private static int costOfCourse = 600;
    private static int id = 1000;

    Scanner input = new Scanner(System.in);

    Student() {

        System.out.println("Enter student first name");
        this.firstName = input.nextLine();
        System.out.println("Enter student last name");
        this.lastName = input.nextLine();
        System.out.println("Enter student class level:\n1- Freshman\n2- Sophmore\n3- Junior \n4- Senior\n");
        this.gradeYear = input.nextInt();
        setStudentId();
    }
    
    private void setStudentId() {
        ++id;
        this.studentId = String.format("%d%d", this.gradeYear, id);
    }

    public void enroll() {
        int courseSelected;
        String choice;

        do {
            System.out.println("Choose a course to enroll:");
            System.out.println("1- " + coursesAvailable[0] + "\n2- " + coursesAvailable[1] + "\n3- " + coursesAvailable[2] +
                    "\n4- " + coursesAvailable[3] + "\n5- " + coursesAvailable[4]);
            courseSelected = input.nextInt();
            input.nextLine();

            if (courseSelected == 1) {
                this.coursesEnrolled.add(coursesAvailable[0]);
            } else if (courseSelected == 2) {
                this.coursesEnrolled.add(coursesAvailable[1]);
            } else if (courseSelected == 3) {
                this.coursesEnrolled.add(coursesAvailable[2]);
            } else if (courseSelected == 4) {
                this.coursesEnrolled.add(coursesAvailable[3]);
            } else if (courseSelected == 5) {
                this.coursesEnrolled.add(coursesAvailable[4]);
            } else {
                System.out.println("Invalid Choice");
            }
            System.out.println("Would like to quit? Y or N");
            choice = input.nextLine();

        } while (!choice.equals("y") && !choice.equals("Y"));

        this.balance = this.coursesEnrolled.size() * costOfCourse;
        System.out.println("Your Balance is: $" + this.balance);

    }

    public void viewBalance() {
        System.out.println("Your balance is " + this.balance);
    }

    public void payTuition() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter your payment");
        double payment = input2.nextInt();
        this.balance -= payment;
        System.out.println("Thanks for your payment of " + payment);
        viewBalance();
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Student ID: " + studentId + "\n" +
                "Grade Year: " + gradeYear + "\n" +
                "Balance: " + balance + "\n" +
                "Courses Enrolled: " + "\n" +
                this.coursesEnrolled;
    }
}
