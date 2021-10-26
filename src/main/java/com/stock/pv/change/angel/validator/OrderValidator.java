package com.stock.pv.change.angel.validator;

import com.stock.pv.change.angel.data.Order;

public class OrderValidator
{
    public static Boolean isOrderValid(Order order){
        if(order == null){
            return false;
        }
        
        return true;
    }
}
