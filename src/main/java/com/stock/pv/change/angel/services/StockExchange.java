package com.stock.pv.change.angel.services;

import com.stock.pv.change.angel.data.Customer;
import com.stock.pv.change.angel.data.Order;
import com.stock.pv.change.angel.data.Stock;
import com.stock.pv.change.angel.exception.InvalidCustomer;
import com.stock.pv.change.angel.exception.InvalidTrade;
import com.stock.pv.change.angel.util.CustomerManager;
import com.stock.pv.change.angel.util.OrderManager;
import com.stock.pv.change.angel.util.StockManager;

public class StockExchange
{

    static{
        tradeProcess();
    }

    public static String addCustomer(Customer customer) throws InvalidCustomer
    {
        return CustomerManager.addCustomer(customer);
    }

    public static void addOrder(Order order)
    {
        OrderManager.addOrder(
                new Order(
                        order.getToken(),
                        order.getSymbol(),
                        order.getQuantity(),
                        order.getPrice()
                )
        );
    }

    public static void orderProcess()
    {
        Thread orderProcessor = new Thread()
        {
            public void run()
            {
                while(true){
                    if(!OrderManager.getBuyOrders().isEmpty()){
                        Order buyOrder = OrderManager.getBuyOrders().poll();
                        try{
                            CustomerManager.getCustomerByToken(buyOrder.getToken()).addStock(new Stock(
                                    buyOrder.getSymbol()
                            ), buyOrder.getQuantity());
                        }catch(InvalidCustomer invalidCustomer){
                            invalidCustomer.printStackTrace();
                        }
                    }
                }
            }
        };

        orderProcessor.start();
    }

    public static void tradeProcess()
    {
        Thread tradeProcessor = new Thread()
        {
            public void run()
            {
                while(true){
                    if(!OrderManager.getSellOrders().isEmpty()){
                        Order order = OrderManager.getSellOrders().element();
                        if(StockManager.isTradeHappen(new Stock(order.getSymbol(), order.getPrice()))){
                            try{
                                CustomerManager.getCustomerByToken(order.getToken()).removeStock(new Stock(
                                        order.getSymbol()
                                ), order.getQuantity());
                            }catch(InvalidTrade invalidTrade){
                                invalidTrade.printStackTrace();
                            }catch(InvalidCustomer invalidCustomer){
                                invalidCustomer.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        tradeProcessor.start();
    }
}
