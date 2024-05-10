package com.javne.SpringApp.impl;

import com.javne.SpringApp.GreenPrinter;
import org.springframework.stereotype.Component;



public class PolishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "zielony";
    }
}
