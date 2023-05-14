import java.util.*;

public class Test {
    public static void main(String[] args) {
        Theatre t = new Theatre();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Seat Class:");
        int seatClass = sc.nextInt();
        t.ticketReservation(seatClass);
        System.out.println("First Class:");
        t.printArray(t.getFirstClassSeats(), 4);

        System.out.println("Enter Seat to Cancel -1 to exit:");
        int seat = sc.nextInt();
        while (seat != -1) {
            System.out.println("Enter Seat to Cancel -1 to exit:");
            t.cancelReservation(seatClass, seat, t.getFirstClassSeats(), 4);
            t.printArray(t.getFirstClassSeats(), 4);
            seat = sc.nextInt();
        }

        System.out.println("Total cost: $" + t.getTotalCost());
        t.resetReservations();
        t.printArray(t.getFirstClassSeats(), 4);

        // System.out.println("Second Class:");
        // for (int i = 0; i < 8; i++) {
        // for (int j = 0; j < 5; j++) {
        // System.out.print(t.getSecondClassSeats()[i][j] + " ");
        // }
        // System.out.println("\n");
        // }
        // System.out.println("Third Class:");
        // for (int i = 0; i < 10; i++) {
        // for (int j = 0; j < 5; j++) {
        // System.out.print(t.getThirdClassSeats()[i][j] + " ");
        // }
        // System.out.println("\n");
        // }

        sc.close();
    }
}
