package com.stock.pv.change.angel.data;

import com.stock.pv.change.angel.exception.InvalidTrade;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Customer implements Serializable
{

    private String              token;
    private String              name;
    private Map<String,Integer> stocks;

    public void setStocks(Map<String,Integer> stocks)
    {
        this.stocks = stocks;
    }

    public Map<String,Integer> getStocks()
    {
        return stocks;
    }

    public void addStock(Stock stock, Integer quantity)
    {
        if(stocks != null){
            if(stocks.containsKey(stock.getSymbol())){
                Integer newQuantity = stocks.get(stock.getSymbol())+quantity;
                stocks.replace(stock.getSymbol(), newQuantity);
            }
        }else{
            stocks = new HashMap<String,Integer>();
            stocks.put(stock.getSymbol(), quantity);
        }
    }

    public void removeStock(Stock stock, Integer quantity) throws InvalidTrade
    {
        if(quantity<0){
            throw new InvalidTrade("Quantity can not be zero");
        }

        if(stocks != null){
            if(stocks.containsKey(stock.getSymbol())){
                Integer newQuantity = stocks.get(stock.getSymbol())-quantity;
                if(newQuantity<=0){
                    throw new InvalidTrade("Quantity can not be zero");
                }
                stocks.replace(stock.getSymbol(), newQuantity);
            }
        }else{
            throw new InvalidTrade("Customer doesn't exist");
        }
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Customer(String name)
    {
        this.name = name;
    }

    public Customer(String token, String name)
    {
        this.token = token;
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if(!getToken().equals(customer.getToken())) return false;
        return getName().equals(customer.getName());
    }
}

