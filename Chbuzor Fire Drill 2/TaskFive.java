import java.util.Scanner;

public class Taskfive {
    public static void main(String... args) {
        
Scanner wisdom = new Scanner(System.in);
        
int total = 0;
        
for (int counter = 1; counter <= 10; counter++) {
           
System.out.print("Enter a number: ");
     int number = wisdom.nextInt();
            
		if (number % 2 == 0) {
		    total += number;
		}
        }
        
	System.out.println("\nOga your Total of the Even numbers is: " + total);
    }
}