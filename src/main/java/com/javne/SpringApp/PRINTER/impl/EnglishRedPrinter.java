package com.javne.SpringApp.PRINTER.impl;

import com.javne.SpringApp.PRINTER.RedPrinter;
import org.springframework.stereotype.Component;


@Component
public class EnglishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "red";
    }
}
