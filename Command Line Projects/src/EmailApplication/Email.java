package EmailApplication;

import java.util.Scanner;

public class Email {

    String firstName;
    String lastName;
    String department;
    String password;
    String alternateEmail;
    String email;
    int mailBoxCapacity = 500;
    int defaultPasswordLenght = 10;
    String companySuffix = "pixeel.com";

    static Scanner input = new Scanner(System.in);

    public Email() {
        System.out.println("Enter first name and last name");
        String name = input.nextLine();
        String[] names = name.split(" ", 2);
        this.firstName = names[0];
        this.lastName = names[1];
        System.out.println("EMAIL CREATED: " + firstName + " " + lastName);

        this.department = setDepartment();


        if(!department.equals("")) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@" + department + "." + companySuffix;
        } else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"+ companySuffix;
        }

        System.out.println("YOUR EMAIL ADDRESS IS : " + email);

        this.password = generateRandomPassword(defaultPasswordLenght);
        System.out.println("YOUR PASSWORD IS: " + password);

        System.out.println("YOUR MAILBOX CAPACITY IS : " + mailBoxCapacity + "MB");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void changePassword(String newPassword){
        this.password = newPassword;
        System.out.println("Your password was changed to " + newPassword);
    }

    public void setAlternateAdress(String alternateAdress) {
        this.alternateEmail = alternateAdress;
        System.out.println("The alternate email address was set to " + alternateAdress);
    }

    public void setCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
        System.out.println("The Mailbox was changed to " + capacity);
    }

    private String generateRandomPassword(int lenght){
        String charSet = "ABCDEFGHIJLMNOPQRSTUWXYZ1234567890$%#@!";
        char[] password = new char[lenght];
        for(int i = 0; i < lenght; i++) {
            int randIndex = (int)(Math.random() * charSet.length());
            password[i] = charSet.charAt(randIndex);
        }
        return new String(password);
    }

    private static String setDepartment() {
        System.out.println("Enter your department:\n1 for Sales\n2 for IT\n3 for Accounting\n0 for none");
        int dep = input.nextInt();
        if(dep == 1) { return "sales"; }
        else if (dep == 2){ return "dev"; }
        else if (dep == 3){  return "acct"; }
        else return "";

    }
}
