package com.stock.pv.change.angel.validator;

import com.stock.pv.change.angel.data.Customer;

public class CustomerValidator
{

    public static Boolean isValidForAdd(Customer customer){
        if(customer == null){
            return false;
        }

        return isCustomerNameValid(customer.getName());
    }

    public static Boolean isValidForRemove(Customer customer)
    {
        if(customer == null){
            return false;
        }

        return isCustomerNameValid(customer.getName()) && isCustomerTokenValid(customer.getToken());
    }

    private static Boolean isCustomerNameValid(String customerName){
        return customerName!=null && !customerName.isBlank();
    }

    private static Boolean isCustomerTokenValid(String customerToken){
        return customerToken!=null && !customerToken.isBlank();
    }
}
