import java.util.*;

public class Theatre {
    private char[][] firstClassSeats;
    private char[][] secondClassSeats;
    private char[][] thirdClassSeats;
    private int totalCost;
    private Scanner sc;

    public Theatre() {
        sc = new Scanner(System.in);
        firstClassSeats = new char[4][5];
        secondClassSeats = new char[8][5];
        thirdClassSeats = new char[10][5];
        totalCost = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++)
                firstClassSeats[i][j] = 'O';

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 5; j++)
                secondClassSeats[i][j] = 'O';

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 5; j++)
                thirdClassSeats[i][j] = 'O';
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public char[][] getFirstClassSeats() {
        return firstClassSeats;
    }

    public char[][] getSecondClassSeats() {
        return secondClassSeats;
    }

    public char[][] getThirdClassSeats() {
        return thirdClassSeats;
    }

    public void reserveSeat(int seatClass, int seatNumber, char[][] arr, int row) {
        if (seatNumber > row * 5 || seatNumber < 1) {
            System.out.println("Please enter a valid seat number.");
        }

        int count = 0, i = 0, j = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < 5 && count != seatNumber; j++) {
                count++;
                if (count == seatNumber) {
                    if (arr[i][j] == 'O') {
                        arr[i][j] = 'X';
                        if (seatClass == 1) {
                            totalCost += 50;
                        } else if (seatClass == 2) {
                            totalCost += 15;
                        } else if (seatClass == 3) {
                            totalCost += 10;
                        }
                    } else {
                        System.out.println("This seat is already reserved or not found.");
                    }
                }
            }
        }
    }

    public void printArray(char[][] arr, int row) {
        int count = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(count + "," + arr[i][j] + " ");
                count++;
            }
            System.out.println("\n");
        }
    }

    public void ticketReservation(int seatClass) {
        System.out.println("Choose the class Number you want to make a reservation in:");
        System.out.println("1) First Class");
        System.out.println("2) Second Class");
        System.out.println("3) Third Class");
        int seat;

        if (seatClass == 1) {
            printArray(firstClassSeats, 4);
            System.out.println("Enter the seat Number (enter -1 to finish):");
            seat = sc.nextInt();
            while (seat != -1) {
                reserveSeat(seatClass, seat, firstClassSeats, 4);
                System.out.println("Enter the seat Number (enter -1 to finish):");
                printArray(firstClassSeats, 4);
                seat = sc.nextInt();
            }

        } else if (seatClass == 2) {
            printArray(secondClassSeats, 8);
            System.out.println("Enter the seat Number (enter -1 to finish):");
            seat = sc.nextInt();
            while (seat != -1) {
                reserveSeat(seatClass, seat, secondClassSeats, 8);
                System.out.println("Enter the seat Number (enter -1 to finish):");
                seat = sc.nextInt();
            }

        } else if (seatClass == 3) {
            printArray(thirdClassSeats, 10);
            System.out.println("Enter the seat Number (enter -1 to finish):");
            seat = sc.nextInt();
            while (seat != -1) {
                reserveSeat(seatClass, seat, thirdClassSeats, 10);
                System.out.println("Enter the seat Number (enter -1 to finish):");
                seat = sc.nextInt();
            }

        } else {
            System.out.println("Please Choose a valid Class");
            return;
        }

        System.out.println("Total cost: $" + totalCost);
    }

    public void cancelReservation(int seatClass, int seatNumber, char[][] arr, int row) {
        if (seatNumber > row * 5 || seatNumber < 1) {
            System.out.println("Please enter a valid seat number.");
        }

        int count = 0, i = 0, j = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < 5 && count != seatNumber; j++) {
                count++;
                if (count == seatNumber) {
                    if (arr[i][j] == 'X') {
                        arr[i][j] = 'O';
                        if (seatClass == 1) {
                            totalCost -= 50;
                        } else if (seatClass == 2) {
                            totalCost -= 15;
                        } else if (seatClass == 3) {
                            totalCost -= 10;
                        }
                    } else {
                        System.out.println("This seat is already Cancelled or not found.");
                    }
                }
            }
        }
    }

    public void resetReservations() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++)
                firstClassSeats[i][j] = 'O';

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 5; j++)
                secondClassSeats[i][j] = 'O';

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 5; j++)
                thirdClassSeats[i][j] = 'O';
    }

}
