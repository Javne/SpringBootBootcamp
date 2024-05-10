package com.javne.SpringApp.impl;

import com.javne.SpringApp.RedPrinter;

public class PolishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "czerwony";
    }
}
