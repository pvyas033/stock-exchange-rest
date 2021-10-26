package com.stock.pv.change.angel.data;

import java.util.Random;

public class StockPriceGenerator
{

    public static Double getPrice()
    {
        Random theRandom = new Random();
        double theRandomValue = 0.0;

        // Checking for a valid range-
        if(Double.valueOf(max-min).isInfinite() == false)
            theRandomValue = min+(max-min)*theRandom.nextDouble();

        return theRandomValue;
    }

    private static Double min = 10D;
    private static Double max = 1000D;
}
