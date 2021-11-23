package com.moodyjun;

public abstract class IceCream {
    private IceCreamFlavour flavour;

    protected IceCream(IceCreamFlavour iceCreamFlavour){
        this.flavour = iceCreamFlavour;
    }

    public String getName() {
        return flavour.getName();
    }

    public Double getPrice() {
        return flavour.getPrice();
    }
}
