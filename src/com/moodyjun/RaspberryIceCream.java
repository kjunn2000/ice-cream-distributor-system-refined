package com.moodyjun;

public class RaspberryIceCream implements IceCreamFlavour {
    private String name = "Raspberry";
    private Double price = 3.0;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
