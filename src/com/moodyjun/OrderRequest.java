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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public IceCream getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(IceCream orderItem) {
        this.orderItem = orderItem;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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
