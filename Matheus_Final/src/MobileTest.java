/**
 @author: Matheus Teixeira
 Id: 301236904
 Final
 */
import java.sql.*;

import static java.lang.Math.round;

public class MobileTest {
    private static Connection connection;
    private static String TABLE_NAME = "Matheus_Mobile";

    public static void main(String[] args) {

        //Create Connection
        createConnection();

        //create table
        createTable();

        //insert records
        insertRecords("A101", 135, 100.5f, 50.5f);
        insertRecords("A102", 205.7f, 130.0f, 187.5f);
        insertRecords("A103", 100, 223.5f, 147.5f);
        insertRecords("A104", 97.5f, 127.5f, 117.5f);

        //retrieve record
        retrieveRecords();

//      close connection
//        closeConnection();
    }

    public static void createConnection(){
        String host = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";   //for execution from college campus
//        String host = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD"; //for execution from remote/home
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

    public static void closeConnection(){
        try{
            if(!connection.isClosed()){
                connection.close();
                System.out.println("Database connection closed successfully");
            }
        }catch (SQLException se){
            System.out.println("Cannot terminate connection with database : " + se);
        }
    }

    public static void createTable(){
        try{

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, TABLE_NAME, null);

            if (resultSet.next()){
                System.out.println("Table with same name already exist in the database");
            }else {
                System.out.println("Creating new table with name " + TABLE_NAME);
                String query = "CREATE TABLE " + TABLE_NAME + " (AccountNumber VARCHAR2(4), LocalMinutes NUMBER(5,2), RoamingMinutes NUMBER(5,2), OverageMinutes NUMBER(5,2))";
                System.out.println("Query : " + query);

                if (!connection.isClosed()) {
                    Statement stmt = connection.createStatement();

                    int n = stmt.executeUpdate(query);
                    System.out.println((n + 1) + " tables created");

                    stmt.close();
                }
            }//else ends

        }catch (SQLException se){
            System.out.println("Cannot create table : " + se);
        }
    }

    public static void insertRecords(String accountNumber, double localMinutes, double roamingMinutes, double overageMinutes){
        try{
            if (!connection.isClosed()) {
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?)");

                stmt.setString(1, accountNumber);
                stmt.setDouble(2, localMinutes);
                stmt.setDouble(3, roamingMinutes);
                stmt.setDouble(4, overageMinutes);

                int n = stmt.executeUpdate();
                System.out.println(n + " records inserted");

                stmt.close();
            }

        }catch (SQLException se){
            System.out.println("Cannot insert record : " + se);
        }
    }

    public static void retrieveRecords(){
        double localMinutes;
        double roamingMinutes;
        double overageMinutes;
        double totalCharges;

        try{

            //SELECT * FROM TABLE_NAME
            String query = "SELECT * FROM " + TABLE_NAME;
            System.out.println("query : " + query);

            if (!connection.isClosed()) {
                Statement stmt = connection.createStatement();

                ResultSet resultSet = stmt.executeQuery(query);
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int numberOfColumns = resultSetMetaData.getColumnCount();

                String output = "";

                while(resultSet.next()){


                    localMinutes = resultSet.getDouble(2);
                    roamingMinutes = resultSet.getDouble(3);
                    overageMinutes = resultSet.getDouble(4);
                    totalCharges = 0.1*localMinutes + 0.2*roamingMinutes + 0.5*overageMinutes;
                    totalCharges = totalCharges * 1.13;
                    totalCharges = totalCharges * 100;
                    totalCharges = Math.round(totalCharges);
                    totalCharges = totalCharges / 100;



                    output = "";

                    output += resultSet.getString(1);
                    output += " ---- LOCAL_MINUTES: ";

                    output +=  String.format("$ %.2f", localMinutes);
                    output += " mins ROAMING_MINUTES: ";
                    output +=  String.format("$ %.2f", roamingMinutes);
                    output += " mins OVERAGE_MINUTES: ";
                    output += String.format("$ %.2f", overageMinutes);
                    output += " mins payment: ";
                    output += String.format("$ %.2f", totalCharges);

                    System.out.println(output);
                }

                stmt.close();
            }

        }catch (SQLException se){
            System.out.println("Cannot retrieve records : " + se);
        }
    }
}