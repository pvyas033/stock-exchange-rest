package com.stock.pv.change.angel.exception;

public class InvalidTrade extends AngelException
{
    private String message;

    public InvalidTrade(String message){
        super("InvalidTrade  : "+message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
