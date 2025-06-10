package OnlineReservationSystem;
import java.util.*; 
public class ReservationSystem {
	static Scanner sc = new Scanner(System.in);
    static String loginUser = "user";
    static String loginPass = "pass";

    static class Ticket {
        String name;
        String from;
        String to;
        String date;
        String classType;
        int trainNo;
        String trainName;
        String pnr;

        Ticket(String name, String from, String to, String date, String classType, int trainNo, String trainName, String pnr) {
            this.name = name;
            this.from = from;
            this.to = to;
            this.date = date;
            this.classType = classType;
            this.trainNo = trainNo;
            this.trainName = trainName;
            this.pnr = pnr;
        }
    }

    static Map<String, Ticket> ticketDatabase = new HashMap<>();

    public static void main(String[] args) {
        if (login()) {
            while (true) {
                System.out.println("\n--- Online Reservation System ---");
                System.out.println("1. Reserve Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        reserveTicket();
                        break;
                    case 2:
                        cancelTicket();
                        break;
                    case 3:
                        System.out.println("Thank you for using the Reservation System!");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } else {
            System.out.println("Login failed. Exiting...");
        }
    }

    static boolean login() {
        System.out.println("--- Login Form ---");
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        return user.equals(loginUser) && pass.equals(loginPass);
    }

    static void reserveTicket() {
        System.out.println("\n--- Reservation Form ---");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("From: ");
        String from = sc.nextLine();
        System.out.print("To: ");
        String to = sc.nextLine();
        System.out.print("Date of journey (DD/MM/YYYY): ");
        String date = sc.nextLine();
        System.out.print("Class type (Sleeper/AC/General): ");
        String classType = sc.nextLine();
        System.out.print("Train number: ");
        int trainNo = sc.nextInt();
        sc.nextLine(); // consume newline
        String trainName = "Express-" + trainNo;

        String pnr = "PNR" + new Random().nextInt(10000);
        Ticket ticket = new Ticket(name, from, to, date, classType, trainNo, trainName, pnr);
        ticketDatabase.put(pnr, ticket);

        System.out.println("Ticket reserved successfully!");
        System.out.println("Your PNR Number: " + pnr);
    }

    static void cancelTicket() {
        System.out.println("\n--- Cancellation Form ---");
        System.out.print("Enter your PNR number: ");
        String pnr = sc.nextLine();

        if (ticketDatabase.containsKey(pnr)) {
            Ticket ticket = ticketDatabase.get(pnr);
            System.out.println("Name: " + ticket.name);
            System.out.println("From: " + ticket.from + ", To: " + ticket.to);
            System.out.println("Date: " + ticket.date + ", Class: " + ticket.classType);
            System.out.println("Train No: " + ticket.trainNo + ", Train Name: " + ticket.trainName);

            System.out.print("Do you want to cancel this ticket? (yes/no): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                ticketDatabase.remove(pnr);
                System.out.println("Ticket cancelled successfully.");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("PNR not found.");
        }
    }
}
