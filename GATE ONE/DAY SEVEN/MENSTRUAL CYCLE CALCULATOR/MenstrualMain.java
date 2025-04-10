import java.util.Scanner;

public class MenstrualMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CycleLogic cycle = new CycleLogic();

        System.out.println("Welcome to Menstrual Cycle App");
        System.out.println("Enter your last period start date (yyyy-mm-dd):");
        String startDate = input.nextLine();

        System.out.println("Enter your cycle length in days:");
        int cycleLength = input.nextInt();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View Flow Date");
            System.out.println("2. View Next Period");
            System.out.println("3. View Ovulation Date");
            System.out.println("4. View Fertile Window");
            System.out.println("5. View Safe Period");
            System.out.println("6. Exit");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Flow Date: " + cycle.calculateFlowDate(startDate));
                    break;
                case 2:
                    System.out.println("Your Next Period: " + cycle.calculateNextPeriod(startDate, cycleLength));
                    break;
                case 3:
                    System.out.println("Your Ovulation Date: " + cycle.calculateOvulationDate(startDate, cycleLength));
                    break;
                case 4:
                    System.out.println(cycle.calculateFertileWindow(startDate, cycleLength));
                    break;
                case 5:
                    System.out.println(cycle.calculateSafePeriod(startDate, cycleLength));
                    break;
                case 6:
                    System.out.println("Thank you for using the app!");
                    return;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }
}
