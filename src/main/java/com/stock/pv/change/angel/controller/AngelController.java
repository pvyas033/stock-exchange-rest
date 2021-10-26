package com.stock.pv.change.angel.controller;

import com.stock.pv.change.angel.data.BuyOrder;
import com.stock.pv.change.angel.data.Customer;
import com.stock.pv.change.angel.data.SellOrder;
import com.stock.pv.change.angel.exception.InvalidCustomer;
import com.stock.pv.change.angel.exception.InvalidOrder;
import com.stock.pv.change.angel.services.StockExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class AngelController
{

    @PostMapping("/register")
    public String register(@RequestBody Customer customer) throws InvalidCustomer
    {
        return StockExchange.addCustomer(
                new Customer(customer.getName())
        );
    }

    @PostMapping("/sell")
    public ResponseEntity sell(@RequestBody SellOrder sellOrder) throws InvalidOrder
    {
        StockExchange.addOrder(sellOrder);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/buy")
    public ResponseEntity buy(@RequestBody BuyOrder buyOrder) throws InvalidOrder
    {
        StockExchange.addOrder(buyOrder);
        return ResponseEntity.ok().build();
    }

}
