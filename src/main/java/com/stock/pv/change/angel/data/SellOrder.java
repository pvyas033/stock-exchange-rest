package com.stock.pv.change.angel.data;

public class SellOrder extends Order
{

    public SellOrder(String token, String symbol, Integer quantity, Double price)
    {
        super(token, symbol, quantity, price, OrderType.SELL);
    }

}
