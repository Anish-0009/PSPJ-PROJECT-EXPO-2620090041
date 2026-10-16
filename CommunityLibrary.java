import java.util.Scanner;

public class CommunityLibrary {

    static Scanner sc = new Scanner(System.in);

    static String[] bookNames = {
        "Java Programming",
        "Data Structures",
        "Computer Networks",
        "Database Management",
        "Operating Systems"
    };

    static boolean[] issued = new boolean[5];
    static int bookCount = 5;

    static void displayBooks() {
        System.out.println("\n===== BOOK LIST =====");

        for (int i = 0; i < bookCount; i++) {
            System.out.print((i + 1) + ". " + bookNames[i]);

            if (issued[i]) {
                System.out.println(" - Issued");
            } else {
                System.out.println(" - Available");
            }
        }
    }

    static void issueBook() {
        displayBooks();

        System.out.print("\nEnter book number to issue: ");
        int bookNumber = sc.nextInt();

        if (bookNumber >= 1 && bookNumber <= bookCount) {
            if (!issued[bookNumber - 1]) {
                issued[bookNumber - 1] = true;
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book is already issued.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

    static void returnBook() {
        displayBooks();

        System.out.print("\nEnter book number to return: ");
        int bookNumber = sc.nextInt();

        if (bookNumber >= 1 && bookNumber <= bookCount) {
            if (issued[bookNumber - 1]) {
                issued[bookNumber - 1] = false;
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("This book was not issued.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

    static void searchBook() {
        sc.nextLine();

        System.out.print("\nEnter book name to search: ");
        String name = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (bookNames[i].equalsIgnoreCase(name)) {
                System.out.println("Book Found: " + bookNames[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println(" COMMUNITY LIBRARY MANAGEMENT");
            System.out.println("==============================");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    issueBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    System.out.println("Thank you for using the Library System!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}