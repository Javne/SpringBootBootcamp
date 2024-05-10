package com.javne.SpringApp.impl;

import com.javne.SpringApp.GreenPrinter;
import org.springframework.stereotype.Component;


@Component
public class EnglishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "green";
    }
}
