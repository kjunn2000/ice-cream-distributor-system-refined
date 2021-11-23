package com.moodyjun;

public class CoffeeIceCream implements IceCreamFlavour{
    private final String name = "Coffee";
    private final Double price = 4.0;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
