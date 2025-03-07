import java.util.Scanner;

public class TaskFour {
    public static void main(String... args) {
        
Scanner Wisdom = new Scanner(System.in);
        
int total = 0;
int average = 0;
        
for (int counter = 1; counter <= 10; counter++) {
            
System.out.print("Enter a number: ");
     int score = wisdom.nextInt();
            total += score;
        }
	average = total / 10;
        
	System.out.println("Oga your Total is: " + total);
		System.out.println("Also your average: " + average);
    }
}



