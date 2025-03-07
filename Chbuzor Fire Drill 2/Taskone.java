import java.util.Scanner;

public class TaskOne {
    public static void main(String... args) {
        
Scanner scanner = new Scanner(System.in);
        
int sum = 0; 
        
for (int counter = 1; counter <= 10; counter++) {
            
System.out.print("Enter a number: ");
     int score = scanner.nextInt();
            sum += score;
        }

        System.out.println("Total: " + sum);
    }
}



