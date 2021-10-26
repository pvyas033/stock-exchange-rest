package com.stock.pv.change.angel.data;

public class Stock
{

    private String symbol;
    private String securityName;
    private Double price;

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public String getSecurityName()
    {
        return securityName;
    }

    public void setSecurityName(String securityName)
    {
        this.securityName = securityName;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Stock(String symbol, String securityName)
    {
        this.symbol = symbol;
        this.securityName = securityName;
    }

    public Stock(String symbol){
        this.symbol = symbol;
    }
    public Stock(String symbol, String securityName, Double price)
    {
        this.symbol = symbol;
        this.securityName = securityName;
        this.price = price;
    }

    public Stock(String symbol, Double price)
    {
        this.symbol = symbol;
        this.price = price;
    }
}
