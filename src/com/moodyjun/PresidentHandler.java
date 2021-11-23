package com.moodyjun;

public class PresidentHandler extends OrderRequestHandler {

    @Override
    public void handleRequest(OrderRequest or){
        if(or.getTotalAmount() <= 300000) {
            System.out.println("\nOrder is under RM300,000-> Approved \n" + or);
        }else {
            if (nextHandler == null) {
                System.out.println("Order amount over authorization limit, please contact customer service for assistant.");
                return;
            }
            nextHandler.handleRequest(or);
        }
    }
}
