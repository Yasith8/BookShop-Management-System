package commandLineCLI;
import java.util.Scanner;

public class CLIProgram {
      public static void main (String[] args) {
    	  
    	  System.out.println("Student Registration Form");
    	  System.out.println();
    	  
    	  Scanner sc = new Scanner(System.in);
    	  
    	  System.out.println("Enter Your First Name : ");
    	  String firstName = sc.nextLine();
    	  System.out.println();
    	  
    	  System.out.println("Enter Your Last Name : ");
    	  String lastName = sc.nextLine();
    	  System.out.println();
    	  
    	  System.out.println("Select Your Gender : Male-->M   Female-->F ");
    	  String gender = sc.next().substring(0,1).toUpperCase();
    	  System.out.println();
    	  
    	  System.out.println("Enter Your Age : ");
    	  int age = sc.nextInt();
    	  System.out.println();
    	  
    	  System.out.println("Enter Your Mobile Number : ");
    	  int mobile = sc.nextInt();
    	  System.out.println();
    	  
    	  System.out.println("Name : "+firstName+" "+ lastName);
    	  System.out.println("Gender : "+gender+"  Age : "+age);
    	  System.out.println("Contact Number : "+mobile);
    	  
      }
}
