package com.example.demo.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
       buttonDailyReportClose.setOnAction(actionEvent -> SwitchButtonSceneManager(buttonDailyReportClose));
    }
    public void loadDailyReport() throws SQLException {
        DecimalFormat dF = new DecimalFormat( "####.##" );
        int id = 0;
        int table = 0;
        String dishName = "";
        double price = 0;
        int amount = 0;
        double total = 0;
        boolean isService = false;
        StringBuilder orderText =
                new StringBuilder("- - - - - - - - - - - - - - - - - >>>     DAILY ORDER REPORT    <<< - - - - - - - - - - - - - - - - \n");
        String orderTotalText = "";
        String buffer = "";
        double totalDaily = 0;
        double serviceSingle;
        double serviceDaily = 0;

        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);
        String select = Const.REPORT_QUERY;
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            id = resultSet.getInt(1);
            table = resultSet.getInt(2);
            dishName = resultSet.getString(3);
            price = resultSet.getDouble(4);
            amount = resultSet.getInt(5);
            total = resultSet.getDouble(6);
            isService = Boolean.parseBoolean(resultSet.getString(7));
        {
        if (amount!=0){
            buffer = "\n" + dishName + " - > " +  dF.format(price) + " €\t" + " x "+ amount + " qt.  - - - - -  "
                    + dF.format(total)+ " €";
            totalDaily += total;
            orderText.append(buffer);
            buffer = "";
        }
        else {
            if(isService) {
                double service = 0.1;
                serviceSingle = total * service;
                totalDaily += total;
                serviceDaily += serviceSingle;
                buffer = "\n\nID[" + id + "] Table № " + table + "\tOrder price: " + dF.format(total) + " €\t"
                        + "Service 10%: " + dF.format(serviceSingle) + " €\t"
                        + "Total price: " + dF.format(total+serviceSingle) + "€\n"
                        + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";
                orderText.append(buffer);
                buffer = "";
            }
                else {
                    double service = 0;
                    serviceSingle = total * service;
                    totalDaily += total;
                    serviceDaily += serviceSingle;
                    buffer = "\n\nID[" + id + "] Table№ " + table + "Order price: " + dF.format(total) + " €\t"
                            + "Service 10%: " + "NONE" + "\t"
                            + "Total price: " + dF.format(total+serviceSingle) + "€\n"
                            + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";
                    orderText.append(buffer);
                    buffer = "";
                    }
                }
            }
        }
        {
            buffer = "\nDaily count: " + dF.format(totalDaily) + " €\t\t\tService: " + dF.format(serviceDaily)
                    + " €\t\t\tTotal: " + dF.format(totalDaily + serviceDaily) + " €";
            orderText.append(orderTotalText);
            orderText.append(buffer);
            buffer = "";
        }
        setDailyReport(orderText.toString());
        setDailyTotal((totalDaily+serviceDaily) + " €");
        dailyText.setText(dailyReport);
        textDailyTotal.setText(dailyTotal);
        preparedStatement.close();
        connection.close();
    }
}


