package com.javne.SpringApp.PRINTER.impl;

import com.javne.SpringApp.PRINTER.GreenPrinter;


public class PolishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "zielony";
    }
}
