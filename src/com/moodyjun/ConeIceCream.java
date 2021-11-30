package com.moodyjun;

public class ConeIceCream extends IceCream{

    private String name = "Cone";
    private Double price = 1.00;

    public ConeIceCream(IceCreamFlavour iceCreamFlavour) {
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
