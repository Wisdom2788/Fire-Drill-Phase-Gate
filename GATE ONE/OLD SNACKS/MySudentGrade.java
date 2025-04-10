import java.util.Scanner;

public class StudentGradingSystem {

    public static void main(String... args) {

        Scanner wisdom = new Scanner(System.in);

        System.out.println("Enter Number Of Students: ")
        int numberOfStudents = wisdom.nextInt();
        while (numberOfStudents < 1 || numberOfStudents > 100) {
            System.out.println("Please input a valid amount (1-100):");
            numberOfStudents = wisdom.nextInt();
        }

        System.out.println("""
                Saving >>>>>>>>
                Saved Successfully.
                """);

        System.out.println("Enter number of Subjects:");
        int numberOfSubjects = wisdom.nextInt();
        while (numberOfSubjects < 1) {
            System.out.println(" Oga !!!Please enter a valid amount (at least 1):");
            numberOfSubjects = wisdom.nextInt();
        }

        System.out.println("""
                Saving >>>>>>>>
                Saved Successfully.
                """);

        int[][] studentGrade = new int[numberOfStudents][numberOfSubjects];

        for (int row = 0; row < numberOfStudents; row++) {
            System.out.println("Entering scores for student " + (row + 1) + ":");
            for (int column = 0; column < numberOfSubjects; column++) {
                System.out.println("Enter score for subject " + (column + 1) + ":");
                studentGrade[row][column] = wisdom.nextInt();
            }
        }

        System.out.println("""
                Saving >>>>>>>>
                Saved Successfully.
                """);

        int[] totalScores = new int[numberOfStudents];
        double[] averageScores = new double[numberOfStudents];

        for (int row = 0; row < numberOfStudents; row++) {
            int total = 0;
            for (int column = 0; column < numberOfSubjects; column++) {
                total += studentGrade[row][column];
            }
            totalScores[row] = total;
            averageScores[row] = (double) total / numberOfSubjects;
        }

        int[] positions = new int[numberOfStudents];
        for (int rankCheck = 0; rankCheck < numberOfStudents; rankCheck++) {
            positions[rankCheck] = 1;
            for (int ranking = 0; ranking < numberOfStudents; j++) {
                if (totalScores[ranking] > totalScores[rankCheck]) {
                    positions[rankCheck]++;
                }
            }
        }

        System.out.println("\nStudent Results:");
        System.out.println("+------------+------------+------------+------------+");
        System.out.println("| Student No | Total Score | Average    | Position   |");
        System.out.println("+------------+------------+------------+------------+");

        for (int row = 0; row < numberOfStudents; row++) {
            System.out.printf("| %-10d | %-11d | %-10.2f | %-10d |%n",
                    (row + 1), totalScores[row], averageScores[row], positions[row]);
        }

        System.out.println("+------------+------------+------------+------------+");
    }
}