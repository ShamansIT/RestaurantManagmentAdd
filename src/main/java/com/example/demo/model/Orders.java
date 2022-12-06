package com.example.demo.model;

public class Orders {

    private int orders_id;
    private int orders_number;
    private short orders_table;
    private String orders_dish;
    private double orders_prise;
    private short orders_amount;

    public Orders() { }

    public Orders(int orders_id, int orders_number, short orders_table, String orders_dish, double orders_prise, short orders_amount) {
        this.orders_id = orders_id;
        this.orders_number = orders_number;
        this.orders_table = orders_table;
        this.orders_dish = orders_dish;
        this.orders_prise = orders_prise;
        this.orders_amount = orders_amount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders_id=" + orders_id +
                ", orders_number=" + orders_number +
                ", orders_table=" + orders_table +
                ", orders_dish='" + orders_dish +
                ", orders_prise=" + orders_prise +
                ", orders_amount=" + orders_amount +
                '}';
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getOrders_number() {
        return orders_number;
    }

    public void setOrders_number(int orders_number) {
        this.orders_number = orders_number;
    }

    public short getOrders_table() {
        return orders_table;
    }

    public void setOrders_table(short orders_table) {
        this.orders_table = orders_table;
    }

    public String getOrders_dish() {
        return orders_dish;
    }

    public void setOrders_dish(String orders_dish) {
        this.orders_dish = orders_dish;
    }

    public double getOrders_prise() {
        return orders_prise;
    }

    public void setOrders_prise(double orders_prise) {
        this.orders_prise = orders_prise;
    }

    public short getOrders_amount() {
        return orders_amount;
    }

    public void setOrders_amount(short orders_amount) {
        this.orders_amount = orders_amount;
    }
}
