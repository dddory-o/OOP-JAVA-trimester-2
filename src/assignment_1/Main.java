package assignment_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CandidateService candidateService = new CandidateService(new CandidateRepository());

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. View all candidates");
            System.out.println("2. Add a candidate");
            System.out.println("3. Update a candidate");
            System.out.println("4. Delete a candidate");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> candidateService.getCandidates().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Enter candidate name: ");
                    String name = scanner.nextLine();
                    candidateService.addCandidate(name);
                }
                case 3 -> {
                    System.out.print("Enter candidate ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    candidateService.updateCandidate(id, name, 0);
                }
                case 4 -> {
                    System.out.print("Enter candidate ID to delete: ");
                    int id = scanner.nextInt();
                    candidateService.deleteCandidate(id);
                }
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
