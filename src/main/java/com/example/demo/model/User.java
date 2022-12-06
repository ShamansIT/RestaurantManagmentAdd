package com.example.demo.model;

public class User {

    private int user_pin;
    private String user_firstname;
    private String user_lastname;
    private short user_age;
    private String user_gender;
    private String user_email;
    private String user_phone;
    private String user_address;
    private String user_city;
    private String user_country;
    private String user_pps;
    private String user_ismanager;

    public User(int user_pin, String user_firstname, String user_lastname, short user_age, String user_gender,
                String user_email, String user_phone, String user_address, String user_city, String user_country,
                String user_pps, String user_ismanager) {
        this.user_pin = user_pin;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_age = user_age;
        this.user_gender = user_gender;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_city = user_city;
        this.user_country = user_country;
        this.user_pps = user_pps;
        this.user_ismanager = user_ismanager;
    }

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "user_pin=" + user_pin +
                ", user_firstname='" + user_firstname +
                ", user_lastname='" + user_lastname +
                ", user_age=" + user_age +
                ", user_gender='" + user_gender +
                ", user_email='" + user_email +
                ", user_phone='" + user_phone +
                ", user_address='" + user_address +
                ", user_city='" + user_city +
                ", user_country='" + user_country +
                ", user_pps='" + user_pps +
                ", user_ismanager='" + user_ismanager +
                '}';
    }

    public int getUser_pin() {
        return user_pin;
    }

    public void setUser_pin(int user_pin) {
        this.user_pin = user_pin;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public short getUser_age() {
        return user_age;
    }

    public void setUser_age(short user_age) {
        this.user_age = user_age;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }

    public String getUser_pps() {
        return user_pps;
    }

    public void setUser_pps(String user_pps) {
        this.user_pps = user_pps;
    }

    public String getUser_ismanager() {
        return user_ismanager;
    }

    public void setUser_ismanager(String user_ismanager) {
        this.user_ismanager = user_ismanager;
    }
}
