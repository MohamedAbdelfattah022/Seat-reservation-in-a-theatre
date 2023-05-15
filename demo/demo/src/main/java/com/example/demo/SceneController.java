package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;

public class SceneController {

@FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToStartMenu(ActionEvent event) throws IOException {
        root =FXMLLoader.load(getClass().getResource("start.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToFirstClass(ActionEvent event) throws IOException{
        root =FXMLLoader.load(getClass().getResource("firstClass.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSecondClass(ActionEvent event) throws IOException{
        root =FXMLLoader.load(getClass().getResource("secondClass.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToThirdClass(ActionEvent event) throws IOException{
        root =FXMLLoader.load(getClass().getResource("thirdClass.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
