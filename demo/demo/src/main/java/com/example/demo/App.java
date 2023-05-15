package com.example.demo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class App extends Application {

    public static void main(String[]args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
            Scene startMenu = new Scene(root);
            stage.setScene(startMenu);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}



