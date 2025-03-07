import java.util.Scanner;

public class TaskEight {
    public static void main(String... args) {
       
Scanner wisdom = new Scanner(System.in);
       
int total = 0;

for (int counter = 1; counter <= 10; counter++) {
 
while (true) {
 System.out.print("Enter a number: ");
      int number = wisdom.nextInt();

                if (number >= 0 && number <= 100) {
                    total += number;
                    break;
                } else {
                    System.out.println("Oga !!! Please enter a score between 0 and 100.");
                }
            }
        }

        System.out.println("\nOga the Total of the valid numbers is: " + total);

    }
}