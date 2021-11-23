package com.moodyjun;

public class RaspberryIceCream implements IceCreamFlavour {
    private final String name = "Raspberry";
    private final Double price = 3.0;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
