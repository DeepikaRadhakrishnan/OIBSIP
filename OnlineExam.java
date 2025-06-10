package com.ProjectPackage;

import java.util.*;

public class OnlineExam {
    
	static Scanner sc = new Scanner(System.in);
    static String username;
    static String password;

    static boolean isLoggedIn = false;
    static int score = 0;

    public static void main(String[] args) {
        register();
        login();
        if (isLoggedIn) {
            mainMenu();
        }
    }

    static void register() {
        System.out.println("--- Registration ---");
        System.out.print("Create a username: ");
        username = sc.nextLine();
        System.out.print("Create a password: ");
        password = sc.nextLine();
        System.out.println("Registration successful!\n");
    }

    static void login() {
        System.out.println("--- Login ---");
        while (true) {
            System.out.print("Enter username: ");
            String user = sc.nextLine();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();

            if (user.equals(username) && pass.equals(password)) {
                System.out.println("Login successful!\n");
                isLoggedIn = true;
                break;
            } else {
                System.out.println("Invalid credentials. Please try again.\n");
            }
        }
    }

    static void mainMenu() {
        int choice;
        do {
            System.out.println("--- Main Menu ---");
            System.out.println("1. Start Exam");
            System.out.println("2. Update Profile");
            System.out.println("3. Logout");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    startExam();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        } while (choice != 3);
    }

    static void startExam() {
        System.out.println("\n--- Exam Started ---");
        System.out.println("Answer the following MCQs (Timer: 60 seconds)");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Auto-submitting...");
                System.out.println("Your Score: " + score + "/3\n");
                System.exit(0);
            }
        }, 60000);

        int ans;

        System.out.println("\nQ1. What is the capital of India?");
        System.out.println("1) Mumbai  2) New Delhi  3) Chennai  4) Kolkata");
        ans = sc.nextInt();
        if (ans == 2) score++;

        System.out.println("\nQ2. Who invented Java?");
        System.out.println("1) Elon Musk  2) James Gosling  3) Dennis Ritchie  4) Bjarne Stroustrup");
        ans = sc.nextInt();
        if (ans == 2) score++;

        System.out.println("\nQ3. Which data type is used to create a variable that should store text?");
        System.out.println("1) myString  2) string  3) String  4) Txt");
        ans = sc.nextInt();
        if (ans == 3) score++;

        timer.cancel();
        System.out.println("\nExam finished.");
        System.out.println("Your Score: " + score + "/3\n");
    }

    static void updateProfile() {
        System.out.println("\n--- Update Profile ---");
        System.out.print("Enter new username: ");
        username = sc.nextLine();
        System.out.print("Enter new password: ");
        password = sc.nextLine();
        System.out.println("Profile updated successfully!\n");
    }

    static void logout() {
        System.out.println("\nLogging out...");
        isLoggedIn = false;
        System.out.println("Session closed. Thank you!\n");
    }
}
