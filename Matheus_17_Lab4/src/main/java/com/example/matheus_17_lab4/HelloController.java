/**
@author: Matheus Teixeira
 Id: 301236904
 Lab 4
*/
package com.example.matheus_17_lab4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    //Form fields
    @FXML private ComboBox cmbItem;
    @FXML private ComboBox cmbQty;
    @FXML private TextField tfName;
    @FXML private TextField tfPhone;
    @FXML private TextField tfAddress;
    @FXML private RadioButton rdbPick;
    @FXML private RadioButton rdbDelivery;
    @FXML private Label lblOutput;
    @FXML private Label lblNumberItems;
//________________________________________________________________
    Map<String, String> priceDict = new HashMap<String, String>();
    //Controller variables
    private String item;
    private String qty;
    private ObservableList<String> itemList = FXCollections.observableArrayList("Milk", "Bread", "Coffee", "Rice", "Beans");
    private ObservableList<String> qtyList = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    private String name;
    private String phone;
    private String address;
    private String mode = "Pick Up";
    private ToggleGroup rdbModeGroup;
    private int numberItems = 0;
    private double totalPrice = 0;
    double shipping = 0.0;
    private ArrayList<ArrayList<String>> cart
            = new ArrayList<ArrayList<String> >();
    private boolean orderSent = false;
//________________________________________________

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rdbModeGroup = new ToggleGroup();

        rdbPick.setSelected(true);
        rdbPick.setToggleGroup(rdbModeGroup);
        rdbDelivery.setToggleGroup(rdbModeGroup);

        cmbItem.setItems(itemList);
        cmbQty.setItems(qtyList);

        priceDict.put("Milk", "3.00");
        priceDict.put("Bread", "1.50");
        priceDict.put("Coffee", "5.00");
        priceDict.put("Rice", "10.00");
        priceDict.put("Beans", "1.20");

    }
    @FXML
    public void onItemSelected(ActionEvent actionEvent) {

        if (cmbItem.getValue().toString().isEmpty()){
            item = "NA";
        }else{
            item = cmbItem.getValue().toString();
        }
    }
    @FXML
    public void onQtySelected(ActionEvent actionEvent) {

        if (cmbQty.getValue().toString().isEmpty()){
            qty = "NA";
        }else{
            qty = cmbQty.getValue().toString();
        }
    }
    @FXML
    public void onAddClick(ActionEvent actionEvent) {
        if(!qty.isEmpty() && !item.isEmpty()){
            numberItems += 1;
            cart.add(new ArrayList<String>());
            cart.get(cart.size()-1).addAll(0, Arrays.asList(qty,item));
            lblNumberItems.setText("Number of Items in cart: " + numberItems);
        }
    }
    @FXML
    public void onModeSelected(ActionEvent actionEvent) {
        RadioButton selectedRadioButton = (RadioButton) actionEvent.getSource();
        mode = selectedRadioButton.getText();
    }
    @FXML
    public void onOrderClick(ActionEvent actionEvent) {
        String outputMessage = "---------------------------------------------------------------------\n";

        if (tfName.getText().isEmpty()){
            name = "NA";
        }else {
            name = tfName.getText();
        }

        if (tfPhone.getText().isEmpty()){
            phone = "NA";
        }else {
            phone = tfPhone.getText();
        }

        if (tfAddress.getText().isEmpty()){
            address = "NA";
        }else {
            address = tfAddress.getText();
        }

        outputMessage += "Name: " + name + "\n";
        name = "";
        tfName.setText(name);

        outputMessage += "Phone: " + phone + "\n";
        phone = "";
        tfPhone.setText(phone);

        outputMessage += "Address: " + address + "\n";
        address = "";
        tfAddress.setText(address);

        double price = 0;
        for (ArrayList<String>item:cart) {
            price =  Double.valueOf(item.get(0)) * Double.valueOf(priceDict.get(item.get(1)));
            outputMessage += item.get(0) + "x " + String.format("%-15s", item.get(1) + "(" + priceDict.get(item.get(1)) + ")").replace(" ", ".") + String.format("%15.2f $", price).replace(" ", ".") + "\n";
            totalPrice += price;
        }
        cart.removeAll(cart);

        outputMessage += "-------------------------------\n";
        outputMessage += String.format("Total: %27.2f $\n", totalPrice);
        outputMessage += String.format("Tax: %30.2f $\n", 0.1 * totalPrice);
        if(mode.equals("Delivery")){
            shipping = 5.0;
            outputMessage += String.format("Shipping: %21.2f $\n", shipping);
        }
        outputMessage += "-------------------------------\n";
        outputMessage += String.format("Total Cost: %19.2f $\n", 1.1*totalPrice + shipping);
        totalPrice = 0;
        shipping = 0;
        lblNumberItems.setText("");
        rdbPick.setSelected(true);
        numberItems = 0;

        lblOutput.setText(outputMessage);
    }

}
