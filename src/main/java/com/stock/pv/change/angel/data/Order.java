package com.stock.pv.change.angel.data;

public class Order implements IOrder
{

    private String    token;
    private String    symbol;
    private Integer   quantity;
    private Double    price;
    private OrderType orderType;

    public Order(String token, String symbol, Integer quantity, Double price)
    {
        this.token = token;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    public Order(String token, String symbol, Integer quantity, Double price, OrderType orderType)
    {
        this(token, symbol, quantity, price);
        this.orderType = orderType;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public OrderType getOrderType()
    {
        return this.orderType;
    }

    @Override
    public String toString()
    {
        return "Order{"+
                "token='"+token+'\''+
                ", symbol='"+symbol+'\''+
                ", quantity="+quantity+
                ", price="+price+
                ", orderType="+orderType.toString()+
                '}';
    }
}
