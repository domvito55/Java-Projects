/**
 @author: Matheus Teixeira
 Id: 301236904
 Lab 5
 */
package com.example.matheus_17_lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Matheus Teixeira");
        FXMLLoader fxmlLoader = new FXMLLoader(StoreApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 210);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}