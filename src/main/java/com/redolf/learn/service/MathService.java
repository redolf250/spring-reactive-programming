package com.redolf.learn.service;


import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

@Slf4j
public class MathService {

    private int result;
    public int add(int x, int y) {
        result = Math.addExact(x,y);
        return result;
    }

    public int subtract(int x, int y) {
        result = Math.subtractExact(x,y);
        return result;
    }

    public int multiply(int x){
        result = Math.multiplyExact(x,x);
        return result;
    }

    public double hypot(int x, int y){
        result = (int) Math.hypot(x,y);
        return result;
    }

    public int getResult() {
        return result;
    }
}
