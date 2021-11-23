package com.moodyjun;

public class StickIceCream extends IceCream{

    private final String name = "Stick";
    private final Double price = 2.00;

    public StickIceCream(IceCreamFlavour iceCreamFlavour) {
        super(iceCreamFlavour);
    }

    @Override
    public String getName() {
        return super.getName() + " (" + name + ")";
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + price;
    }

    @Override
    public String toString() {
        return "Name : " + getName()+ '\n' +
                "Price : " + getPrice()+ '\n';
    }
}
