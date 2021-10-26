package com.stock.pv.change.angel.exception;

public class InvalidCustomer extends AngelException
{
    private String message;

    public InvalidCustomer(String message){
        super("InvalidCustomer  : "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
