package com.moodyjun;

public class SeniorExecutiveHandler extends OrderRequestHandler {

    @Override
    public void handleRequest(OrderRequest or){
        if(or.getTotalAmount() <= 10000) {
            System.out.println("\nOrder is under RM10,000-> Approved \n" + or);
        }else {
            if (nextHandler == null) {
                System.out.println("Order amount over authorization limit, " +
                        "please contact customer service for assistant.");
                return;
            }
            nextHandler.handleRequest(or);
        }
    }
}
