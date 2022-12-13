package com.example.demo.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo.data.Const;
import com.example.demo.data.DataBaseProcessor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class DailyReportController implements SceneSwitch {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonDailyReportClose;

    @FXML
    private Text dailyText;

    @FXML
    private Text textDailyTotal;

    private String dailyReport = "";
    private String dailyTotal = "";

    public String getDailyTotal() {
        return dailyTotal;
    }
    public void setDailyTotal(String dailyTotal) {
        this.dailyTotal = dailyTotal;
    }
    public String getDailyReport() {
        return dailyReport;
    }
    public void setDailyReport(String dailyReport) {
        this.dailyReport = dailyReport;
    }
    @Override
    public String toString() {
        return "DailyReportController{" +
                "dailyReport='" + dailyReport + '\'' +
                ", dailyTotal='" + dailyTotal + '\'' +
                '}';
    }


    @FXML
    void initialize() throws SQLException {

       loadDailyReport();
       dailyText.setText(dailyReport);
       textDailyTotal.setText(dailyTotal);

       buttonDailyReportClose.setOnAction(actionEvent -> SwitchButtonSceneManager(buttonDailyReportClose));

    }
    public void loadDailyReport() throws SQLException {
        int id = 0;
        int table = 0;
        String dishName = "";
        double price = 0;
        int amount = 0;
        double total = 0;
        boolean isService = false;
        String orderText = "--------------------DAILY-ORDER-REPORT---------------------\n";
        String orderTotalText = "--------------------------TOTAL----------------------------\n";
        String buffer = "";
        double totalDaily = 0;
        double serviceSingle = 0;
        double serviceDaily = 0;


        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);

        String select = "SELECT * FROM " + Const.REPORT_NAME;

        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            id = resultSet.getInt(1);
            table = resultSet.getInt(2);
            dishName = resultSet.getString(3);
            price = resultSet.getDouble(4);
            amount = resultSet.getInt(5);
            total = resultSet.getDouble(6);
            isService = resultSet.getBoolean(7);
        }

        if (amount!=0){
            buffer = dishName + " - > " + price + " €.\t" + " X "+ amount + "qt.  -----   "  + total + " €.\n";
            totalDaily += total;
            orderText += buffer;
            buffer = "";
        }
        else {
            if(isService) {
                double service = 0.1;
                serviceSingle = total * service;
                totalDaily += total;
                serviceDaily += serviceSingle;
                buffer = "ID[" + id + "] Table № " + table + "Order price: " + total + " €.\t"
                        + "Service 10%: " + serviceSingle + " €.\t"
                        + "Total price: " + total+serviceSingle + "€.\n"
                        +"------------------------------------------------------------------------\n";
                orderText += buffer;
                buffer = "";
            }
            else {
                double service = 0;
                serviceSingle = total * service;
                totalDaily += total;
                serviceDaily += serviceSingle;
                buffer = "ID[" + id + "] Table№ " + table + "Order price: " + total + " €.\t"
                        + "Service 10%: " + "NONE" + "\t"
                        + "Total price: " + total+serviceSingle + "€.\n"
                        +"------------------------------------------------------------------------\n";
                orderText += buffer;
                buffer = "";
            }
        }
        {
            buffer = "Daily count: " + totalDaily + " €.\tService: " + serviceDaily
                    + " €.\tTotal: " + (totalDaily+serviceDaily) + " €.";
            orderText += orderTotalText;
            orderText += buffer;
            buffer = "";
        }
        System.out.println(orderText);
        setDailyReport(orderText);
        setDailyTotal(String.valueOf(totalDaily+serviceDaily));
        preparedStatement.close();
        connection.close();
    }

}


