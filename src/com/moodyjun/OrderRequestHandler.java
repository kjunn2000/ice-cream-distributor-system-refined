package com.moodyjun;

public abstract class OrderRequestHandler{

    protected OrderRequestHandler nextHandler;

    public void setNextHandler(OrderRequestHandler prHandler) {
        this.nextHandler = prHandler;
    }

    public abstract void handleRequest(OrderRequest pr);
}

