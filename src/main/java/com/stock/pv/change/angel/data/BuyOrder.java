package com.stock.pv.change.angel.data;

public class BuyOrder extends Order
{

    public BuyOrder(String token, String symbol, Integer quantity, Double price)
    {
        super(token, symbol, quantity, price, OrderType.BUY);
    }
}
