package com.stock.pv.change.angel.util;

import com.stock.pv.change.angel.data.Order;
import com.stock.pv.change.angel.data.OrderType;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderManager
{

    static class CustomOrderComparator implements Comparator<Order>
    {

        @Override
        public int compare(Order order1, Order order2)
        {
            if(order1.getOrderType() == OrderType.SELL)
                return order1.getQuantity()<order2.getQuantity() ? 1 : -1;
            else if(order1.getOrderType() == OrderType.BUY)
                return order1.getQuantity()>order2.getQuantity() ? 1 : -1;
            else return 0;
        }
    }

    public static void addOrder(Order order)
    {
        if(order.getOrderType() == OrderType.SELL){
            sellOrders.add(order);
        }else if(order.getOrderType() == OrderType.BUY){
            buyOrders.add(order);
        }
    }

    static{
        CustomOrderComparator customOrderComparator = new CustomOrderComparator();

        buyOrders = new PriorityQueue<>(customOrderComparator);
        sellOrders = new PriorityQueue<>(customOrderComparator);
    }

    public static PriorityQueue<Order> getBuyOrders()
    {
        return buyOrders;
    }

    public static void setBuyOrders(PriorityQueue<Order> buyOrders)
    {
        OrderManager.buyOrders = buyOrders;
    }

    public static PriorityQueue<Order> getSellOrders()
    {
        return sellOrders;
    }

    public static void setSellOrders(PriorityQueue<Order> sellOrders)
    {
        OrderManager.sellOrders = sellOrders;
    }

    private static PriorityQueue<Order> buyOrders;
    private static PriorityQueue<Order> sellOrders;
}
