/**
 @author: Matheus Teixeira
 Id: 301236904
 Lab 5
 */
package com.example.matheus_17_lab5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class StoreController implements Initializable {
    //________________________Form fields______________
    @FXML private ComboBox cmbItem;
    @FXML private ComboBox cmbQty;
    @FXML private TextField tfName;
    @FXML private TextField tfPhone;
    @FXML private TextField tfAddress;
    @FXML private RadioButton rdbPick;
    @FXML private RadioButton rdbDelivery;
//    @FXML private Label lblOutput;
    @FXML private Label lblNumberItems;
    //____________________Database__________________
    DatabaseOperations dbo = new DatabaseOperations();
    String TABLE_NAME = "MATHEUS_ORDERS";
    String numberValues = " VALUES(?, ?, ?, ?)";
    String fields = " (orderNumber NUMBER(6), productName VARCHAR2(20), qty NUMBER(1), price NUMBER(5,2) )";

    //____________________Interface_________________
    Map<String, String> priceDict = new HashMap<String, String>();
    //Controller variables
    private int orderNumber = 0;
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
        //_____________Database__________
        dbo.createConnection();
        //create table
        dbo.createTable(TABLE_NAME, fields);
        //getting last order number to continue the counting
        orderNumber = dbo.getLastOrderNumber(TABLE_NAME, "orderNumber") + 1;


        //_____________Interface__________
        //Delivery/PickUp radio initialization
        rdbModeGroup = new ToggleGroup();
        rdbPick.setSelected(true);
        rdbPick.setToggleGroup(rdbModeGroup);
        rdbDelivery.setToggleGroup(rdbModeGroup);

        //Combobox lists
        cmbItem.setItems(itemList);
        cmbQty.setItems(qtyList);

        //price dictionary
        priceDict.put("Milk", "3.00");
        priceDict.put("Bread", "1.50");
        priceDict.put("Coffee", "5.00");
        priceDict.put("Rice", "10.00");
        priceDict.put("Beans", "1.20");

    }

    //Item combo list selection controller
    @FXML
    public void onItemSelected(ActionEvent actionEvent) {
        if (cmbItem.getValue().toString().isEmpty()){
            item = "NA";
        }else{
            item = cmbItem.getValue().toString();
        }
    }

    //Quantity combo list selection controller
    @FXML
    public void onQtySelected(ActionEvent actionEvent) {
        if (cmbQty.getValue().toString().isEmpty()){
            qty = "NA";
        }else{
            qty = cmbQty.getValue().toString();
        }
    }

    //Add item button controller
    @FXML
    public void onAddClick(ActionEvent actionEvent) {
//        System.out.println();
        if((qty != null) && (item != null)){
            numberItems += 1;
            ArrayList list = new ArrayList();
            list.add(orderNumber);
            list.add(item);
            list.add(qty);
            list.add(priceDict.get(item));
//            System.out.println(list);
            dbo.insertPrepared(TABLE_NAME, numberValues, list);
            //Old version
//            cart.add(new ArrayList<String>());
//            cart.get(cart.size()-1).addAll(0, Arrays.asList(qty,item));
            lblNumberItems.setText("Number of Items in cart: " + numberItems);
        }
    }

    //Delivery/PickUp radio controller
    @FXML
    public void onModeSelected(ActionEvent actionEvent) {
        RadioButton selectedRadioButton = (RadioButton) actionEvent.getSource();
        mode = selectedRadioButton.getText();
    }

    //generate receipt
    @FXML
    public void onOrderClick(ActionEvent actionEvent) {
        String outputMessage = "--------------------------------------------------\n";

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

        //Creating receipt string
        outputMessage += "Name: " + name + "\n";
        name = "";
        tfName.setText(name);

        outputMessage += "Phone: " + phone + "\n";
        phone = "";
        tfPhone.setText(phone);

        outputMessage += "Address: " + address + "\n";
        address = "";
        tfAddress.setText(address);

        cart = dbo.retrieveOrder(TABLE_NAME, orderNumber);
//        System.out.println(cart);

        double price = 0;
        for (ArrayList<String>item:cart) {
            price =  Double.valueOf(item.get(2)) * Double.valueOf(item.get(3));
            outputMessage += item.get(2) + "x " +
                             String.format("%-15s", item.get(1) + "(" + item.get(3) + ")").replace(" ", ".") +
                             String.format("%15.2f $", price).replace(" ", ".") + "\n";
            totalPrice += price;
        }
        cart.removeAll(cart);

        outputMessage += "-------------------------------\n";
        outputMessage += "Order Number: " + orderNumber + "\n";
        outputMessage += String.format("Total: %27.2f $\n", totalPrice);
        outputMessage += String.format("Tax: %30.2f $\n", 0.1 * totalPrice);
        if(mode.equals("Delivery")){
            shipping = 5.0;
            outputMessage += String.format("Shipping: %21.2f $\n", shipping);
        } else {
            shipping = 0;
        }
        outputMessage += "-------------------------------\n";
        outputMessage += String.format("Total Cost: %19.2f $\n", 1.1*totalPrice + shipping);
        totalPrice = 0;
        shipping = 0;
        lblNumberItems.setText("");
        rdbPick.setSelected(true);
        mode = "Pick up";
        numberItems = 0;

        //Old version
//        lblOutput.setText(outputMessage);
        //Creating receipt window
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("receiptWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 260, 360));
            stage.show();

            ReceiptController controller = fxmlLoader.getController();
            controller.onOrderClick(outputMessage);

        } catch(Exception e) {
            e.printStackTrace();
        }

        orderNumber++;
    }
}
