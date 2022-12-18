package com.example.demo.controller;

import com.example.demo.data.Const;
import com.example.demo.data.DataBaseProcessor;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuController extends DishHeadController implements SceneSwitch {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleButton addDish1;

    @FXML
    private ToggleButton addDish2;

    @FXML
    private ToggleButton addDish3;

    @FXML
    private ToggleButton addDish4;

    @FXML
    private ToggleButton addDish5;

    @FXML
    private ToggleButton addDish6;

    @FXML
    private ToggleButton addDish7;

    @FXML
    private ToggleButton addDish8;

    @FXML
    private Button buttonAddToOrder;

    @FXML
    private Button buttonAmountMinus;

    @FXML
    private Button buttonAmountPlus;

    @FXML
    private Button buttonCheckOrderField;

    @FXML
    private Button buttonCloseTable;

    @FXML
    private Button buttonCompleteOrder;

    @FXML
    private Button buttonManager;

    @FXML
    private CheckBox checkLessFivePerson;

    @FXML
    private Button clearList;

    @FXML
    private AnchorPane leftFieldOrder;

    @FXML
    private TextField menuFieldAmountDish;

    @FXML
    private TextField menuPreviewOrder;

    @FXML
    private Button switchToBreakfast;

    @FXML
    private Button switchToDinner;

    @FXML
    private Button switchToDrinks;

    @FXML
    private Button switchToLunch;

    @FXML
    private Text textNumOfClient;

    @FXML
    private Text textOrderInfo;

    @FXML
    private Text textOrderLeft;

    @FXML
    private Text textTableNumber;

    @FXML
    private Text textTotalPrice;

    @FXML
    private Text tipsService;

    @FXML
    private ToggleButton toggleTable11;

    @FXML
    private ToggleButton toggleTable12;

    @FXML
    private ToggleButton toggleTable13;

    @FXML
    private ToggleButton toggleTable14;

    @FXML
    private ToggleButton toggleTable15;

    @FXML
    private ToggleButton toggleTable16;

    @FXML
    private ToggleButton toggleTable20;

    @FXML
    private ToggleButton toggleTable36;

    @FXML
    private ToggleButton toggleTable37;

    @FXML
    private ToggleButton toggleTable38;

    @FXML
    private ToggleButton toggleTable39;


    private boolean table11 = true;
    private boolean table12 = true;
    private boolean table13 = true;
    private boolean table14 = true;
    private boolean table15 = true;
    private boolean table16 = true;
    private boolean table20 = true;
    private boolean table36 = true;
    private boolean table37 = true;
    private boolean table38 = true;
    private boolean table39 = true;

    private String buttonIdentity = "breakfast";
    public String getButtonIdentity() {
        return buttonIdentity;
    }
    public void setButtonIdentity(String buttonIdentity) {
        this.buttonIdentity = buttonIdentity;
    }
    private void showLineText(){
        menuPreviewOrder.setVisible(true);
    }
    private void showOffLineText(){
        menuPreviewOrder.setVisible(false);
    }

    ArrayList<Integer> tableCondition= new ArrayList<>();

    private void setAmountRefresh(){
        setAmountDish(Integer.toString(1));
        setNumberAmount(1);
        menuFieldAmountDish.setText("1");
    }

    private void setAmountDishPlus(){
        setNumberAmount(Integer.parseInt(menuFieldAmountDish.getText()));
        setNumberAmount(getNumberAmount()+1);
        setAmountDish(Integer.toString(getNumberAmount()));
        menuFieldAmountDish.setText(String.valueOf(getNumberAmount()));
    }

   private void setAmountDishMinus(){
        setNumberAmount(Integer.parseInt(menuFieldAmountDish.getText()));
        if (getNumberAmount() > 1)
            setNumberAmount(getNumberAmount()-1);
        setAmountDish(Integer.toString(getNumberAmount()));
        menuFieldAmountDish.setText(String.valueOf(getNumberAmount()));
    }

    private void refreshTipsInfo(){
        if(getTotalPrice() == 0){
            tipsService.setVisible(false);
        }
        else {
            if (checkLessFivePerson.isSelected()) {
                setIsService(true);
                setTipsOver(0.1);
                tipsService.setText(setTips());
                tipsService.setVisible(true);
                textTotalPrice.setText(setTotalPricePlusTips());
            } else {
                setIsService(false);
                setTipsOver(0);
                tipsService.setVisible(false);
                textTotalPrice.setText(setTotalPriceText());
            }
        }
    }


    private String loadButton(int buttonNumber) throws SQLException {
        String buttonName = "";
        boolean visible = false;
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);
        String select = "SELECT * FROM demodata.dish WHERE id = "+ "'" + buttonNumber + "'" +
                " AND typedish = " + "'" + getButtonIdentity() + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            buttonName = resultSet.getString(2);
            visible = resultSet.getBoolean(5);
        }
        preparedStatement.close();
        connection.close();
        return buttonName;
    }

    private void restartButtonName() throws SQLException {
        addDish1.setText(loadButton(1));
        addDish2.setText(loadButton(2));
        addDish3.setText(loadButton(3));
        addDish4.setText(loadButton(4));
        addDish5.setText(loadButton(5));
        addDish6.setText(loadButton(6));
        addDish7.setText(loadButton(7));
        addDish8.setText(loadButton(8));
    }

    private void restartButtonVisible() throws SQLException {
        addDish1.setVisible(visibleButton(1));
        addDish2.setVisible(visibleButton(2));
        addDish3.setVisible(visibleButton(3));
        addDish4.setVisible(visibleButton(4));
        addDish5.setVisible(visibleButton(5));
        addDish6.setVisible(visibleButton(6));
        addDish7.setVisible(visibleButton(7));
        addDish8.setVisible(visibleButton(8));
    }

    private boolean visibleButton(int buttonNumber) throws SQLException {
        boolean visible = false;
        DataBaseProcessor dataBaseProcessor = new DataBaseProcessor();
        Connection connection = dataBaseProcessor.getConnection(Const.URL, Const.USERNAME,Const.PASSWORD);
        String select = "SELECT * FROM demodata.dish WHERE id = "+ "'" + buttonNumber + "'" +
                " AND typedish = " + "'" + getButtonIdentity() + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            visible = resultSet.getBoolean(5);
        }
        preparedStatement.close();
        connection.close();
        return visible;
    }

    private void menuNavigationDefaultStyle(){
        switchToBreakfast.setStyle(deactivatedNavigation());
        switchToLunch.setStyle(deactivatedNavigation());
        switchToDinner.setStyle(deactivatedNavigation());
        switchToDrinks.setStyle(deactivatedNavigation());
    }

    public String greenButtonStyle(){
        return "-fx-background-color: linear-gradient(#76994E, #4D7025);" +
                "-fx-background-radius: 7;" +
                "-fx-border-radius: 7;" +
                "-fx-border-color: #FFFFFF;" +
                "-fx-text-fill:#FFFFFF;" +
                "-fx-font-size:18;";
    }
    public String orangeButtonStyle(){
        return  "-fx-background-color:#FF6600;" +
                "-fx-border-color: #FFFFFF;" +
                "-fx-background-radius: 7;" +
                "-fx-border-radius: 7;" +
                "-fx-text-fill:#FFFFFF;" +
                "-fx-font-size:18;";
    }

    public String darkBlueButtonStyle(){
        return  "-fx-background-color:#1d228f;" +
                "-fx-border-color: #FFFFFF;" +
                "-fx-background-radius: 7;" +
                "-fx-border-radius: 7;" +
                "-fx-text-fill:#FFFFFF;" +
                "-fx-font-size:18;";
    }

    public String deactivatedNavigation(){
        return "-fx-background-color: linear-gradient(#8EB4C1, #BADDE7);" +
                "-fx-text-fill:#FFFFFF;";
    }

    public String activatedNavigation(){
        return "-fx-background-color: linear-gradient(#DAE2E1, #F9FAFA);" +
                "-fx-text-fill:#0f5169;";
    }
    public String blueButtonStyle(){
        return  "-fx-background-color:#3782bc;" +
                "-fx-border-color: #FFFFFF;" +
                "-fx-background-radius: 7;" +
                "-fx-border-radius: 7;" +
                "-fx-text-fill:#FFFFFF;" +
                "-fx-font-size:18;";
    }

    private void ActionDish(int numButton){
        setAmountRefresh();
        try { loadDishLine(numButton,getButtonIdentity()); } catch (SQLException e) {
            throw new RuntimeException(e); }
        buttonCheckOrderField.setVisible(false);
        menuPreviewOrder.setText(setPreviewOrderText());
        showLineText();
    }

    public void refreshTable(){
        if(table11){toggleTable11.setStyle(greenButtonStyle());} else{toggleTable11.setStyle(blueButtonStyle());}
        if(table12){toggleTable12.setStyle(greenButtonStyle());} else{toggleTable12.setStyle(blueButtonStyle());}
        if(table13){toggleTable13.setStyle(greenButtonStyle());} else{toggleTable13.setStyle(blueButtonStyle());}
        if(table14){toggleTable14.setStyle(greenButtonStyle());} else{toggleTable14.setStyle(blueButtonStyle());}
        if(table15){toggleTable15.setStyle(greenButtonStyle());} else{toggleTable15.setStyle(blueButtonStyle());}
        if(table16){toggleTable16.setStyle(greenButtonStyle());} else{toggleTable16.setStyle(blueButtonStyle());}
        if(table20){toggleTable20.setStyle(greenButtonStyle());} else{toggleTable20.setStyle(blueButtonStyle());}
        if(table36){toggleTable36.setStyle(greenButtonStyle());} else{toggleTable36.setStyle(blueButtonStyle());}
        if(table37){toggleTable37.setStyle(greenButtonStyle());} else{toggleTable37.setStyle(blueButtonStyle());}
        if(table38){toggleTable38.setStyle(greenButtonStyle());} else{toggleTable38.setStyle(blueButtonStyle());}
        if(table39){toggleTable39.setStyle(greenButtonStyle());} else{toggleTable39.setStyle(blueButtonStyle());}
        buttonCheckOrderField.setVisible(false);
    }

    public void conditionTable(int table, boolean station, ToggleButton toggleButton){
        setTableNumber(table);
        if(station){toggleButton.setStyle(orangeButtonStyle());} else{toggleButton.setStyle(darkBlueButtonStyle());}
    }

    public void setConditionTable(int table){
        if(table == 11){table11 = false;}
        if(table == 12){table12 = false;}
        if(table == 13){table13 = false;}
        if(table == 14){table14 = false;}
        if(table == 15){table15 = false;}
        if(table == 16){table16 = false;}
        if(table == 20){table20 = false;}
        if(table == 36){table36 = false;}
        if(table == 37){table37 = false;}
        if(table == 38){table38 = false;}
        if(table == 39){table39 = false;}
    }

    @FXML
    void initialize() {
        ToggleGroup toggleTable = new ToggleGroup();
        toggleTable11.setToggleGroup(toggleTable);
        toggleTable12.setToggleGroup(toggleTable);
        toggleTable13.setToggleGroup(toggleTable);
        toggleTable14.setToggleGroup(toggleTable);
        toggleTable15.setToggleGroup(toggleTable);
        toggleTable16.setToggleGroup(toggleTable);
        toggleTable20.setToggleGroup(toggleTable);
        toggleTable36.setToggleGroup(toggleTable);
        toggleTable37.setToggleGroup(toggleTable);
        toggleTable38.setToggleGroup(toggleTable);
        toggleTable39.setToggleGroup(toggleTable);

        toggleTable11.setOnAction(actionEvent ->{refreshTable(); conditionTable(11, table11,toggleTable11);});
        toggleTable12.setOnAction(actionEvent ->{refreshTable(); conditionTable(12, table12,toggleTable12);});
        toggleTable13.setOnAction(actionEvent ->{refreshTable(); conditionTable(13, table13,toggleTable13);});
        toggleTable14.setOnAction(actionEvent ->{refreshTable(); conditionTable(14, table14,toggleTable14);});
        toggleTable15.setOnAction(actionEvent ->{refreshTable(); conditionTable(15, table15,toggleTable15);});
        toggleTable16.setOnAction(actionEvent ->{refreshTable(); conditionTable(16, table16,toggleTable16);});
        toggleTable20.setOnAction(actionEvent ->{refreshTable(); conditionTable(20, table20,toggleTable20);});
        toggleTable36.setOnAction(actionEvent ->{refreshTable(); conditionTable(36, table36,toggleTable36);});
        toggleTable37.setOnAction(actionEvent ->{refreshTable(); conditionTable(37, table37,toggleTable37);});
        toggleTable38.setOnAction(actionEvent ->{refreshTable(); conditionTable(38, table38,toggleTable38);});
        toggleTable39.setOnAction(actionEvent ->{refreshTable(); conditionTable(39, table39,toggleTable39);});

        ToggleGroup addDishGroup = new ToggleGroup();
        addDish1.setToggleGroup(addDishGroup);
        addDish2.setToggleGroup(addDishGroup);
        addDish3.setToggleGroup(addDishGroup);
        addDish4.setToggleGroup(addDishGroup);
        addDish5.setToggleGroup(addDishGroup);
        addDish6.setToggleGroup(addDishGroup);
        addDish7.setToggleGroup(addDishGroup);
        addDish8.setToggleGroup(addDishGroup);

        addDish1.setOnAction(actionEvent ->{ ActionDish(1); });
        addDish2.setOnAction(actionEvent ->{ ActionDish(2); });
        addDish3.setOnAction(actionEvent ->{ ActionDish(3); });
        addDish4.setOnAction(actionEvent ->{ ActionDish(4); });
        addDish5.setOnAction(actionEvent ->{ ActionDish(5); });
        addDish6.setOnAction(actionEvent ->{ ActionDish(6); });
        addDish7.setOnAction(actionEvent ->{ ActionDish(7); });
        addDish8.setOnAction(actionEvent ->{ ActionDish(8); });

        buttonAddToOrder.setOnAction(actionEvent ->{
            if(getName() == null) {
                buttonCheckOrderField.setText("PICK DISH");
                buttonCheckOrderField.setVisible(true);
            }else {
                if(getTableNumber()==0) {
                    buttonCheckOrderField.setText("PICK TABLE");
                    buttonCheckOrderField.setVisible(true);
                }
                else{
                    setOrderWindowText(getOrderWindowText() + setPreviewWindowText());
                    textOrderLeft.setText(getOrderWindowText());
                    showOffLineText();
                    if(getNumberAmount()>10) {
                        buttonCheckOrderField.setText("CHECK QUANTITY");
                        buttonCheckOrderField.setVisible(true);
                    }
                    setTotalPrice(countTotalPrice());
                    refreshTipsInfo();
                    textTotalPrice.setVisible(true);
                    textTotalPrice.setText(setTotalPriceText());
                    addDishGroup.selectToggle(null);
                    setAmountRefresh();
                    prepareOrderStringToList();
                }
            }
        });

        checkLessFivePerson.setOnAction(actionEvent -> {
            refreshTipsInfo();
        });

        buttonCheckOrderField.setOnAction(actionEvent ->{
            buttonCheckOrderField.setVisible(false);
        });

        clearList.setOnAction(actionEvent -> {
            setOrderWindowText("");
            setTotalPrice(0);
            textTotalPrice.setText("");
            textOrderLeft.setText(getOrderWindowText());
            tipsService.setVisible(false);
            buttonCheckOrderField.setVisible(false);
            setAmountRefresh();
            clearOrderStringToList();
            checkLessFivePerson.setSelected(false);
            refreshTable();
            setTableNumber(0);
        });

        buttonCompleteOrder.setOnAction(actionEvent -> {
            if(getTotalPrice() == 0) {
                buttonCheckOrderField.setText("ADD SOMETHING\nTO ORDER");
                buttonCheckOrderField.setVisible(true);
            } else {
                if(getTableNumber()==0){
                buttonCheckOrderField.setText("PICK TABLE");
                buttonCheckOrderField.setVisible(true);
            } else {
                prepareOrderEndStringToList();
                try {
                    exportOrderToSQL();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                setConditionTable(getTableNumber());
                clearOrderStringToList();
                setOrderWindowText("");
                setTotalPrice(0);
                textTotalPrice.setText("");
                textOrderLeft.setText(getOrderWindowText());
                tipsService.setVisible(false);
                buttonCheckOrderField.setVisible(false);
                setAmountRefresh();
                checkLessFivePerson.setSelected(false);
                refreshTable();
                setTableNumber(0);
            }
          }
        });

        buttonAmountPlus.setOnAction(actionEvent -> {
            setAmountDishPlus();
            menuPreviewOrder.setText(setPreviewOrderText());
        });

        buttonAmountMinus.setOnAction(actionEvent -> {
            setAmountDishMinus();
            menuPreviewOrder.setText(setPreviewOrderText());
        });

        buttonCloseTable.setOnAction(actionEvent -> SwitchButtonSceneCloseTable(buttonCloseTable));
        buttonManager.setOnAction(actionEvent -> SwitchButtonSceneManager(buttonManager));
        switchToBreakfast.setOnAction(actionEvent -> {
            setButtonIdentity("breakfast");
            menuNavigationDefaultStyle();
            switchToBreakfast.setStyle(activatedNavigation());
            try { restartButtonName(); restartButtonVisible();
            } catch (SQLException e) { throw new RuntimeException(e); }
        });

        switchToLunch.setOnAction(actionEvent -> {
            setButtonIdentity("lunch");
            menuNavigationDefaultStyle();
            switchToLunch.setStyle(activatedNavigation());
            try { restartButtonName(); restartButtonVisible();
            } catch (SQLException e) { throw new RuntimeException(e); }

        });
        switchToDinner.setOnAction(actionEvent -> {
            setButtonIdentity("dinner");
            menuNavigationDefaultStyle();
            switchToDinner.setStyle(activatedNavigation());
            try { restartButtonName(); restartButtonVisible();
            } catch (SQLException e) { throw new RuntimeException(e); }
        });
        switchToDrinks.setOnAction(actionEvent -> {
            setButtonIdentity("drinks");
            menuNavigationDefaultStyle();
            switchToDrinks.setStyle(activatedNavigation());
            try { restartButtonName(); restartButtonVisible();
            } catch (SQLException e) { throw new RuntimeException(e); }
        });
    }
}

