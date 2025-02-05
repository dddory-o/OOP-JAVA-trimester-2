package assignment_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExamService examService = new ExamService();

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. View all candidates");
            System.out.println("2. Add a candidate");
            System.out.println("3. Update a candidate");
            System.out.println("4. Delete a candidate");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.println("\nCANDIDATES:");
                    for (String candidate : examService.getCandidates()) {
                        System.out.println(candidate);
                    }
                }
                case 2 -> {
                    System.out.print("Enter candidate name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter candidate age: ");
                    int age = scanner.nextInt();
                    examService.addCandidate(name, age);
                }
                case 3 -> {
                    System.out.print("Enter candidate ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    examService.updateCandidate(id, newName, newAge);
                }
                case 4 -> {
                    System.out.print("Enter candidate ID to delete: ");
                    int id = scanner.nextInt();
                    examService.deleteCandidate(id);
                }
                case 5 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
