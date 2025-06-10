package com.ProjectPackage;

import java.util.*;

public class DigitalLibrarySystem {
    static Scanner sc = new Scanner(System.in);

    static class Book {
        int id;
        String title;
        String author;
        boolean issued = false;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }
    }

    static List<Book> books = new ArrayList<>();
    static String adminUsername = "admin";
    static String adminPassword = "admin123";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to the Digital Library");
            System.out.println("1. Admin Login");
            System.out.println("2. User Access");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userAccess();
                    break;
                case 3:
                    System.out.println("Thank you for using the Library!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void adminLogin() {
        System.out.print("Enter admin username: ");
        String user = sc.nextLine();
        System.out.print("Enter admin password: ");
        String pass = sc.nextLine();

        if (user.equals(adminUsername) && pass.equals(adminPassword)) {
            adminPanel();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    static void adminPanel() {
        while (true) {
            System.out.println("\nAdmin Panel");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View All Books");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void removeBook() {
        System.out.print("Enter book ID to remove: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.id == id) {
                it.remove();
                found = true;
                System.out.println("Book removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    static void userAccess() {
        while (true) {
            System.out.println("\nUser Access");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            String status = b.issued ? "Issued" : "Available";
            System.out.println("ID: " + b.id + ", Title: " + b.title + ", Author: " + b.author + ", Status: " + status);
        }
    }

    static void searchBook() {
        System.out.print("Enter title to search: ");
        String title = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if (b.title.toLowerCase().contains(title)) {
                System.out.println("Found - ID: " + b.id + ", Title: " + b.title + ", Author: " + b.author);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with that title.");
        }
    }

    static void issueBook() {
        System.out.print("Enter book ID to issue: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Book b : books) {
            if (b.id == id && !b.issued) {
                b.issued = true;
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    static void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Book b : books) {
            if (b.id == id && b.issued) {
                b.issued = false;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid book ID or book wasn't issued.");
    }
}
