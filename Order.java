package com.walden.entity;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public class Order {
    private String id;
    private String number;
    private int price;

    private Person person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", number: " + number + ", price: " + price + "}";
    }

}
