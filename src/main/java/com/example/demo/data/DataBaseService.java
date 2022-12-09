package com.example.demo.data;

public class DataBaseService {
    private DishLoader dish;

    public DataBaseService() {
    }

    public DishLoader getDish() {
        this.dish = new DishLoader();
        return this.dish;
    }


}
