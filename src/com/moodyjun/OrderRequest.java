package com.moodyjun;

public class OrderRequest {
    private String orderId;
    private IceCream orderItem;
    private Integer itemQuantity ;
    private double totalAmount;

    public OrderRequest(String orderId, IceCream orderItem, Integer itemQuantity, double totalAmount) {
        this.orderId = orderId;
        this.orderItem = orderItem;
        this.itemQuantity = itemQuantity;
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "\nOrderRequest\n" +
                "Order Id -> " + orderId + '\n' +
                "Order Item -> " + orderItem.getName()+ '\n' +
                "Item Quantity -> " + itemQuantity + '\n' +
                "Total Amount -> " + totalAmount + '\n';
    }
}
