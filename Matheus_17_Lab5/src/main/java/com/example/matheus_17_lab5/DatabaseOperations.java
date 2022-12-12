/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment:
*/
package com.example.matheus_17_lab5;
import java.sql.*;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseOperations {
    //
    private Connection connection;

    public void createConnection(){
//        String host = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";   //for execution from college campus
        String host = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD"; //for execution from remote/home
        String username = "COMP228_F22_jg_39"; //replace with your username
        String password = "Demi2010";

        try{

            //1. import ojdbc6.jar as library under project structure
            //2. register the driver
            Class.forName("oracle.jdbc.OracleDriver");

            //3.Open a connection to the database.
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("Database connection established successfully");

        }catch (ClassNotFoundException cnfe){
            System.out.println("Cannot find the mentioned driver. Please check the driver string.");
        }
        catch (SQLException se){
            System.out.println("Cannot establish connection with database : " + se);
        }
    }

    public void closeConnection(){
        try{
            if(!connection.isClosed()){
                connection.close();
                System.out.println("Database connection closed successfully");
            }
        }catch (SQLException se){
            System.out.println("Cannot terminate connection with database : " + se);
        }
    }

    public void createTable(String TABLE_NAME, String fields){
        try{

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, TABLE_NAME, null);

            if (resultSet.next()){
                System.out.println("Table with same name already exist in the database");
            }else {
                System.out.println("Creating new table with name " + TABLE_NAME);
                String query = "CREATE TABLE " + TABLE_NAME + fields;
                System.out.println("Query : " + query);

                if (!connection.isClosed()) {
                    Statement stmt = connection.createStatement();

                    int n = stmt.executeUpdate(query);
                    System.out.println((n + 1) + " tables created");

                    stmt.close();
                }
            }//else ends

        }catch (Exception se){
            System.out.println("Cannot create table : " + se);
        }
    }

    //__________________Insert Item_____________
    public void insertPrepared(String TABLE_NAME, String numberValues, ArrayList values){
        try{
            if (!connection.isClosed()) {
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + TABLE_NAME + numberValues);

                int index = 1;
                for (Object value:values) {
//                    System.out.println(value);
                    try{
                        stmt.setDouble(index, Double.parseDouble(value.toString()));
                    } catch (Exception e){
                        stmt.setString(index,  (String) value);
                    }
                    index++;
                }

                int n = stmt.executeUpdate();
//                System.out.println(n + " records inserted");

                stmt.close();
            }

        }catch (Exception se){
            System.out.println("Cannot insert record : " + se);
        }
    }

    public int getLastOrderNumber(String TABLE_NAME, String columnName){
        int lastOrderNumber = -1;
        try{
            //SELECT * FROM TABLE
            String query = "SELECT MAX(" + columnName + ") FROM " + TABLE_NAME;
//            System.out.println("query : " + query);

            if (!connection.isClosed()) {
                Statement stmt = connection.createStatement();
                //Getting table
                ResultSet resultSet = stmt.executeQuery(query);
                //getting the number of columns
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int numberOfColumns = resultSetMetaData.getColumnCount();

                //filling the return variable
                resultSet.next();
                if(resultSet.getString(1) != null){
                    lastOrderNumber = Integer.parseInt(resultSet.getString(1));
                } else {
                    lastOrderNumber = 0;
                }

//                System.out.println(resultSet.getString(1));
                stmt.close();
            }
        }catch (Exception se){
            System.out.println("Cannot retrieve records : " + se);
        }
        return lastOrderNumber;
    }

    public ArrayList<ArrayList<String>> retrieveOrder(String TABLE_NAME, int orderNumber){
        ArrayList<ArrayList<String>> order
                = new ArrayList<ArrayList<String> >();
        try{
            //SELECT * FROM TABLE
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE orderNumber = '" + orderNumber + "'";
//            System.out.println("query : " + query);

            if (!connection.isClosed()) {
                Statement stmt = connection.createStatement();
                //Getting table
                ResultSet resultSet = stmt.executeQuery(query);
                //getting the number of columns
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int numberOfColumns = resultSetMetaData.getColumnCount();

                //filling the return variable
                while(resultSet.next()){
//                    System.out.println(resultSet.getString(6));
                    ArrayList<String> product = new ArrayList<String>();
                    for(int i = 1; i <= numberOfColumns; i++){
                        product.add(resultSet.getString(i));
//                        int price = resultSet.getInt(3);
                    }
                    order.add(product);
                }
                //System.out.println(order);
                stmt.close();
            }
        }catch (Exception se){
            System.out.println("Cannot retrieve records : " + se);
        }
        return order;
    }
}
