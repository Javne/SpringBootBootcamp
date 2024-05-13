package com.javne.SpringApp.PRINTER.impl;

import com.javne.SpringApp.PRINTER.BluePrinter;
import org.springframework.stereotype.Component;


@Component
public class EnglishBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "blue";
    }
}
