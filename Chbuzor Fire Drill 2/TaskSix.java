import java.util.Scanner;

public class TaskSix {
    public static void main(String... args) {
        
Scanner wisdom = new Scanner(System.in);
        
int total = 0;
int average = 0;
        
for (int counter = 1; counter <= 10; counter++) {
           
System.out.print("Enter a number: ");
     int number = wisdom.nextInt();
            
		if (number % 2 == 0) {
		    total += number;
		}
        } average = total / 5;
        
	System.out.println("\nOga your Average of the Even numbers is: " + average);
    }
}