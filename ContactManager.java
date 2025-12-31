import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

public class ContactManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n====== Contact Management System ======");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1 -> {  // Add Contact
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    contacts.add(new Contact(name, phone, email));
                    System.out.println("Contact added successfully!");
                }

                case 2 -> {  // View Contacts
                    System.out.println("\n--- Contact List ---");
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts available.");
                    } else {
                        for (int i = 0; i < contacts.size(); i++) {
                            Contact c = contacts.get(i);
                            System.out.println(
                                (i + 1) + ". " + c.name + " - " + c.phone + " - " + c.email
                            );
                        }
                    }
                }

                case 3 -> {  // Search Contact
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    for (Contact c : contacts) {
                        if (c.name.equalsIgnoreCase(searchName)) {
                            System.out.println("Contact Found:");
                            System.out.println("Name: " + c.name);
                            System.out.println("Phone: " + c.phone);
                            System.out.println("Email: " + c.email);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                }

                case 4 -> {  // Delete Contact
                    System.out.print("Enter name to delete: ");
                    String delName = sc.nextLine();

                    boolean removed = contacts.removeIf(c -> c.name.equalsIgnoreCase(delName));

                    if (removed) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                }

                case 5 -> {  // Exit
                    running = false;
                    System.out.println("Exiting Contact Manager...");
                }

                default -> System.out.println("Invalid option! Try again.");
            }
        }

        sc.close();
    }
}
