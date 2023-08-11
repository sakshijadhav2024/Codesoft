import java.util.Scanner;

public class AddressBookApp {
    private AddressBook addressBook;
    private Scanner scanner;

    public AddressBookApp() {
        this.addressBook = new AddressBook();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to Address Book System!");
        System.out.println("1. Add a new contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Display all contacts");
        System.out.println("4. Remove a contact");
        System.out.println("5. Exit");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the new line character from the input buffer

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    displayAllContacts();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    System.out.println("Thank you for using the Address Book System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        if (!name.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty()) {
            Contact contact = new Contact(name, phoneNumber, emailAddress);
            addressBook.addContact(contact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Invalid input. All fields are required.");
        }
    }

    private void searchContact() {
        System.out.print("Enter the name to search: ");
        String name = scanner.nextLine();

        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            System.out.println("Contact found:\n" + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void displayAllContacts() {
        if (addressBook.getAllContacts().isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("All Contacts:");
            for (Contact contact : addressBook.getAllContacts()) {
                System.out.println(contact);
                System.out.println("------------------------------");
            }
        }
    }

    private void removeContact() {
        System.out.print("Enter the name to remove: ");
        String name = scanner.nextLine();

        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            addressBook.removeContact(contact);
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        AddressBookApp app = new AddressBookApp();
        app.start();
    }
}

