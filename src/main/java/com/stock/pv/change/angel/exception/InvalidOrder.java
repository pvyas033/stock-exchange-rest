package com.stock.pv.change.angel.exception;

public class InvalidOrder extends AngelException
{
    private String message;

    public InvalidOrder(String message){
        super("InvalidOrder  : "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
