package com.moodyjun;

import java.util.Objects;

public class IceCreamFactory {
    public IceCream getIceCream(String typeInput, String flavourInput){
        IceCreamFlavour flavour= getFlavour(flavourInput);
        if (Objects.isNull(flavour)){
            return null;
        }
        switch (typeInput){
            case "Cone":{
                return new ConeIceCream(flavour);
            }
            case "Stick":{
                return new StickIceCream(flavour);
            }
            default :{
                return null;
            }
        }
    }

    private IceCreamFlavour getFlavour(String flavour){
        switch(flavour) {
            case "Coffee":{
                return new CoffeeIceCream();
            }
            case "Raspberry":{
                return new RaspberryIceCream();
            }
            default :{
                return null;
            }
        }
    }
}
