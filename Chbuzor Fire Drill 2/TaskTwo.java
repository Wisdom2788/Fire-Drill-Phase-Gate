import java.util.Scanner;

public class TaskTwo {
    public static void main(String... args) {
        
Scanner scanner = new Scanner(System.in);
        
int total = 0;
int average = 0;
        
for (int counter = 1; counter <= 10; counter++) {
            
System.out.print("Enter a number: ");
     int score = scanner.nextInt();
            total += score;
        }
	average = total / 10;
        System.out.println("Oga your Average is: " + average);
    }
}



