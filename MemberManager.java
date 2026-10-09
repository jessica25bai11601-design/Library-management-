import java.util.Scanner;

public class MemberManager {

    private Library library;
    private Scanner scanner;

    public MemberManager(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    public void addMember() {

        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!InputValidator.isValidId(id)) {
            System.out.println("Invalid Member ID.");
            return;
        }

        if (library.findMember(id) != null) {
            System.out.println("A member with this ID already exists.");
            return;
        }

        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        if (!InputValidator.isValidName(name) ||
            !InputValidator.isValidName(department)) {

            System.out.println("Name and department cannot be empty.");
            return;
        }

        Member member = new Member(id, name, department);
        library.addMember(member);

        System.out.println("Member added successfully!");
    }

    public void searchMember() {

        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();

        Member member = library.findMember(id);

        if (member == null) {
            System.out.println("Member not found.");
        } else {
            System.out.println("\nMember found:");
            System.out.println("ID | Name | Department");
            member.displayMember();
        }
    }
}
