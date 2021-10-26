package com.stock.pv.change.angel.services;

import java.util.UUID;

public class TokenGenerator
{
    public static String token(){
        return UUID.randomUUID().toString();
    }
}
