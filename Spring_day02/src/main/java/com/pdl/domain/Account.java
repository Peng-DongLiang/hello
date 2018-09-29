package com.pdl.domain;

import java.io.Serializable;

public class Account implements Serializable{
    private int id;
    private String name;
    private Float money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Account() {
    }

    public Account(int id, String name, Float money) {

        this.id = id;
        this.name = name;
        this.money = money;
    }
}
