package com.example.demo.model;



public class MenuDish {

    private short tableNumber;
    private short dishNumber;
    private double dishPrise;
    private double totalCountTable;


    public short getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(short tableNumber) {
        this.tableNumber = tableNumber;
    }

    public short getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(short dishNumber) {
        this.dishNumber = dishNumber;
    }

    private void totalOrderCount(){ }
    public void addDishToArray(short dishNumber){
        System.out.println(dishNumber);
    }

    public void removeLastDishFromArray(){}

    public void loadToList(){}

    public void loadTableInfo(){}

    public void addTipsOverSexPerson(){

    }

    public void closeTable(){}
    public void printOrderDetail(){}


}
