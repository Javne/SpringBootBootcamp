package com.javne.SpringApp.PRINTER.impl;

import com.javne.SpringApp.PRINTER.RedPrinter;

public class PolishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "czerwony";
    }
}
