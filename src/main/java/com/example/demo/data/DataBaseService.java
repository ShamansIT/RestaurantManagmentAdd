package com.example.demo.data;

import com.example.demo.controller.DishHeadController;

public class DataBaseService {
    private DishHeadController dish;

    public DataBaseService() {
    }

    public DishHeadController getDish() {
        this.dish = new DishHeadController();
        return this.dish;
    }

}
