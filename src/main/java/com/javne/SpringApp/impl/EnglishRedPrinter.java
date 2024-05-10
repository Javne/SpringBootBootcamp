package com.javne.SpringApp.impl;

import com.javne.SpringApp.RedPrinter;
import org.springframework.stereotype.Component;


@Component
public class EnglishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "red";
    }
}
