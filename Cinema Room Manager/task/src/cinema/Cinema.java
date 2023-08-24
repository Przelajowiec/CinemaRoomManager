package cinema;

import java.util.Scanner;
class Ticket {
    int tickets = 0;
    int cost = 0;
    public void sum(int tick) {
        this.tickets += tick;
    }
    public void incomeFromTickets(int cost) {
        this.cost += cost;
    }

    public int getTickets() {
        return tickets;
    }

    public int getCost() {
        return cost;
    }
}

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in The Nightmare Cinema.");
        System.out.println("Enter the number of rows:");;
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] theatre = theatreMake(rows, seats);
        Ticket tickets = new Ticket();
        menu(theatre, rows, seats,tickets);
//        theatrePrint(theatre);
//        System.out.println("Enter a row number:");
//        int row = scanner.nextInt();
//        System.out.println("Enter a seat number in that row:");
//        int seat = scanner.nextInt();
//        System.out.println(buyTicket(row, rows, seats));
//        theatre = checkSeat(theatre, row, seat);
//        theatrePrint(theatre);

    }

    public static void menu(String[][] theatre, int rows, int seats, Ticket ticket) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.println("""
                    
                    1. Show the seats
                    2. Buy a ticket
                    3. Statistics
                    0. Exit""");
            int num = scanner.nextInt();
            switch (num) {
                case 1 -> theatrePrint(theatre);
                case 2 -> buyTicket(theatre, rows, seats, ticket);
                case 3 -> statistics(rows, seats,ticket);
                case 0 -> exit = false;
                default -> System.out.println("Illegal number, please try again");
            }
        }
        System.out.println("Goodbye.");
    }

    public static String[][] theatreMake(int rows, int seats) {
        String[][] theatre = new String[rows+1][seats+1];
        theatre[0][0] = "  ";
        for (int i = 1; i <= seats; i++) {
            theatre[0][i] = (i + " ");
        }
        for (int i = 1; i <= rows; i++) {
            theatre[i][0] = (i + " ");
            for (int j = 1; j <= seats; j++) {
                theatre[i][j] = "S ";
            }
        }
        return theatre;
    }

    public static void theatrePrint(String[][] theatre) {
        System.out.println("The Nightmare Cinema:");
        for (int i = 0; i < theatre.length; i++) {
            for (int j = 0; j < theatre[0].length; j++) {
                System.out.print(theatre[i][j]);
            }
            System.out.println();
        }
    }

    public static void buyTicket(String[][] theatre, int rows, int seats, Ticket ticket) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            if (row > rows) {
                System.out.println("Wrong input!");
            }
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();
            int cost = 0;
            if (row > rows || seat > seats) {
                System.out.println("Wrong input!");
            } else if (theatre[row][seat].equals("B ")) {
                System.out.println("That ticket has already been purchased!");
            } else if (rows * seats < 61 || row <= rows / 2) {
                System.out.println("Ticket price: $10\n");
                cost = 10;
                checkSeat(theatre, row, seat);
                theatrePrint(theatre);
                ticket.sum(1);
                ticket.incomeFromTickets(cost);
                check = false;
            } else {
                System.out.println("Ticket price: $8\n");
                cost = 8;
                checkSeat(theatre, row, seat);
                theatrePrint(theatre);
                ticket.sum(1);
                ticket.incomeFromTickets(cost);
                check = false;
            }
        }

    }

    public static void checkSeat(String[][] theatre, int row, int seat) {
        theatre[row][seat] = "B ";
    }


    public static void statistics(int rows, int seats,Ticket ticket) {
        int totalIncome = 0;
        int totalSeats = rows * seats;
        int expensiveTickets = rows / 2 * seats * 10;
        int cheapTickets = (rows - rows / 2) * seats * 8;
        totalIncome = totalSeats < 61 ? totalSeats * 10 : expensiveTickets + cheapTickets;
        int incomeFromTickets = ticket.getCost();
        int totalTickets = ticket.getTickets();
        double percentOfTickets = (double) totalTickets / totalSeats * 100.0;
        System.out.printf("Number of purchased tickets: %d\n", totalTickets);
        System.out.printf("Percentage: %.2f%%\n", percentOfTickets);
        System.out.printf("Current income: $%d\n", incomeFromTickets);
        System.out.printf("Total income: $%d\n", totalIncome);
    }
}
