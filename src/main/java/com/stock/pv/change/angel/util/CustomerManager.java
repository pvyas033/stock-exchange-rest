package com.stock.pv.change.angel.util;

import com.stock.pv.change.angel.data.Customer;
import com.stock.pv.change.angel.exception.InvalidCustomer;
import com.stock.pv.change.angel.services.TokenGenerator;
import com.stock.pv.change.angel.validator.CustomerValidator;

import java.util.HashMap;
import java.util.Map;

public class CustomerManager
{

    public static Customer getCustomerByToken(String token) throws InvalidCustomer
    {
        if(customerMap == null || !customerMap.containsKey(token)){
            throw new InvalidCustomer("Customer is not valid.");
        }

        return customerMap.get(token);
    }

    public static String addCustomer(Customer customer) throws InvalidCustomer
    {
        if(!CustomerValidator.isValidForAdd(customer)){
            throw new InvalidCustomer("Customer is not valid.");
        }

        if(customer.getToken() != null && customerMap.containsKey(customer.getToken())){
            throw new InvalidCustomer("Customer is already present.");
        }

        String token = TokenGenerator.token();

        customer.setToken(token);
        customerMap.put(token, customer);

        return token;
        // TO-DO : Here we can add code to add customer to database
    }

    public void removeCustomer(Customer customer) throws InvalidCustomer
    {
        if(CustomerValidator.isValidForRemove(customer)){
            if(customerMap.containsKey(customer.getToken())){
                customerMap.remove(customer.getToken(), customer);
            }else{
                throw new InvalidCustomer("Customer not exist.");
            }
        }else{
            throw new InvalidCustomer("Customer is not valid.");
        }

        // TO-DO : Here we can remove code to remove customer to database
    }

    private static void populateCustomers()
    {
        customerMap = new HashMap<String,Customer>();
        // TO-DO : Here we can add database code for populating customer details from backend server
    }

    static{
        populateCustomers();
    }

    private static Map<String,Customer> customerMap;
}


