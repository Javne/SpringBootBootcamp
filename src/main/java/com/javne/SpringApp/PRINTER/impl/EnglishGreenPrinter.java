package com.javne.SpringApp.PRINTER.impl;

import com.javne.SpringApp.PRINTER.GreenPrinter;
import org.springframework.stereotype.Component;


@Component
public class EnglishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "green";
    }
}
