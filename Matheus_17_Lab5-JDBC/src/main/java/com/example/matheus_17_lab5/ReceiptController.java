/**
 @author: Matheus Teixeira
 Id: 301236904
 Lab 5
 */
package com.example.matheus_17_lab5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

public class ReceiptController implements Initializable {
    //________________________Form fields______________
    @FXML private Label lblOutput;
    //___________________________________________Interface_______________

    //________________________________________________
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //__________________Interface_____

    }

    //generate receipt
    @FXML
    public void onOrderClick(String outputMessage) {
        lblOutput.setText(outputMessage);
    }
}
