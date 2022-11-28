package com.example.demo.model;

public class User {

    private String pin;
    private String firstname;
    private String lastname;
    private String age;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String city;

    public User(String pin, String firstname, String lastname, String age, String gender, String email, String phone, String address, String city, String country, String ismanager, String pps) {
        this.pin = pin;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.ismanager = ismanager;
        this.pps = pps;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIsmanager() {
        return ismanager;
    }

    public void setIsmanager(String ismanager) {
        this.ismanager = ismanager;
    }

    public String getPps() {
        return pps;
    }

    public void setPps(String pps) {
        this.pps = pps;
    }

    private String country;
    private String ismanager;
    private String pps;

}
