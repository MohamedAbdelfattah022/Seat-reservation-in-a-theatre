import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Theatre t = new Theatre();
        Scanner sc = new Scanner(System.in);
        t.ticketReservation();
        System.out.println("First Class:");
        // for (int i = 0; i < 4; i++) {
        // for (int j = 0; j < 5; j++) {
        // System.out.print(t.getFirstClassSeats()[i][j] + " ");
        // }
        // System.out.println("\n");
        // }
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
