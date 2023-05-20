package com.example.demo;

import java.util.*;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.IOException;

public class Theatre {
    @FXML
    private char[] firstClassSeats;
    private char[] secondClassSeats;
    private char[] thirdClassSeats;
    private int totalCost;
    private int totalCashback;
    private Scanner sc;
    @FXML
    private AnchorPane firstClass;
    @FXML
    private AnchorPane secondClass;
    @FXML
    private AnchorPane thirdClass;


    public Theatre() {
        sc = new Scanner(System.in);
        firstClassSeats = new char[20];
        secondClassSeats = new char[40];
        thirdClassSeats = new char[50];
        totalCost = 0;
        totalCashback=0;
        for (int i = 0; i < 20; i++)
            firstClassSeats[i] = 'O';

        for (int i = 0; i < 40; i++)
            secondClassSeats[i] = 'O';

        for (int i = 0; i < 50; i++)
            thirdClassSeats[i] = 'O';
    }

    public void switchToStartMenu(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void info() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Seat Reservation");
        alert.setHeaderText(null);
        alert.setContentText("reset Successfully.\nTotal Cashback: "+ totalCashback);
        alert.showAndWait();
    }

    public void ticketReservation(ActionEvent event) {

        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        // Extract the seat number from the button text
        StringTokenizer tokenizer = new StringTokenizer(buttonText, ")");
        int seatNumber = Integer.parseInt(tokenizer.nextToken());

        // Determine the class and index of the seat based on the button's parent
        char[] seatArray;
        int seatIndex;
        if (button.getParent() == firstClass) {
            seatArray = firstClassSeats;
            seatIndex = seatNumber - 1;
        }
        else if (button.getParent() == secondClass) {
            seatArray = secondClassSeats;
            seatIndex = seatNumber - 1;
        }
        else if (button.getParent() == thirdClass) {
            seatArray = thirdClassSeats;
            seatIndex = seatNumber - 1;
        }else{return ;}


        if (seatArray[seatIndex] == 'O') {
            // Reserve the seat and update the seat array and button text
            seatArray[seatIndex] = 'X';
            button.setText(buttonText.replace("O", "X"));

            // Calculate and display the updated total cost
            if (button.getParent() == firstClass) {
                totalCost += 50;
            } else if (button.getParent() == secondClass) {
                totalCost += 15;
            } else if (button.getParent() == thirdClass) {
                totalCost += 10;
            }


            if (button.getParent() == firstClass) {
                TextField totalCostField = (TextField) firstClass.lookup("#totalCostField");
                totalCostField.setText(String.valueOf(totalCost));
            } else if (button.getParent() == secondClass) {
                TextField totalCostField = (TextField) secondClass.lookup("#totalCostField");
                totalCostField.setText(String.valueOf(totalCost));
            } else if (button.getParent() == thirdClass) {
                TextField totalCostField = (TextField) thirdClass.lookup("#totalCostField");
                totalCostField.setText(String.valueOf(totalCost));
            }

        } else {
            System.out.println("This seat is already reserved.");
            cancelReservation(event);
            info();
        }
    }


    public void cancelReservation(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        // Extract the seat number from the button text
        StringTokenizer tokenizer = new StringTokenizer(buttonText, ")");
        int seatNumber = Integer.parseInt(tokenizer.nextToken());

        // Determine the class and index of the seat based on the button's parent
        char[] seatArray;
        int seatIndex;
        if (button.getParent() == firstClass) {
            seatArray = firstClassSeats;
            seatIndex = seatNumber - 1;
        }
        else if (button.getParent() == secondClass) {
            seatArray = secondClassSeats;
            seatIndex = seatNumber - 1;
        }
        else if (button.getParent() == thirdClass) {
            seatArray = thirdClassSeats;
            seatIndex = seatNumber - 1;
        }else{return ;}


        if (seatArray[seatIndex] == 'X') {
            // Reserve the seat and update the seat array and button text
            seatArray[seatIndex] = 'O';
            button.setText(buttonText.replace("X", "O"));

            // Calculate total cost
            if (button.getParent() == firstClass) {
                totalCost -= 50;
                totalCashback+=50;
            } else if (button.getParent() == secondClass) {
                totalCost -= 15;
                totalCashback+=15;
            } else if (button.getParent() == thirdClass) {
                totalCost -= 10;
                totalCashback+=10;
            }

            if (button.getParent() == firstClass) {
                TextField totalCostField = (TextField) firstClass.lookup("#totalCostField");
                totalCostField.setText(String.valueOf(totalCost));
            } else if (button.getParent() == secondClass) {
                TextField totalCostField = (TextField) secondClass.lookup("#totalCostField");
                totalCostField.setText(String.valueOf(totalCost));
            } else if (button.getParent() == thirdClass) {
                TextField totalCostField = (TextField) thirdClass.lookup("#totalCostField");
                totalCostField.setText(String.valueOf(totalCost));
            }

        } else {
            return ;
        }
    }

    public void resetReservations(ActionEvent event) {
        Button button = (Button) event.getSource();
        totalCost=0;
        totalCashback=0;
        if (button.getParent() == firstClass){
            for (int i = 0; i < 20; i++) {
                firstClassSeats[i] = 'O';
            }
            firstClass.lookupAll(".button").forEach(e -> {
                Button btn = (Button) e;
                btn.setText(btn.getText().replace("X","O"));
            });
            TextField totalCostField = (TextField) firstClass.lookup("#totalCostField");
            totalCostField.setText(String.valueOf(totalCost));
        }

        if (button.getParent() == secondClass){
            for (int i = 0; i < 40; i++) {
                secondClassSeats[i] = 'O';
            }
            secondClass.lookupAll(".button").forEach(e -> {
                Button btn = (Button) e;
                btn.setText(btn.getText().replace("X","O"));
            });
            TextField totalCostField = (TextField) secondClass.lookup("#totalCostField");
            totalCostField.setText(String.valueOf(totalCost));
        }

        if (button.getParent() == thirdClass){
            for (int i = 0; i < 50; i++) {
                thirdClassSeats[i] = 'O';
            }
            thirdClass.lookupAll(".button").forEach(e -> {
                Button btn = (Button) e;
                btn.setText(btn.getText().replace("X","O"));
            });
            TextField totalCostField = (TextField) thirdClass.lookup("#totalCostField");
            totalCostField.setText(String.valueOf(totalCost));
        }
    }
}
