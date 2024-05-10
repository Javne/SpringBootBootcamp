package com.javne.SpringApp.impl;

import com.javne.SpringApp.BluePrinter;
import org.springframework.stereotype.Component;


@Component
public class EnglishBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "blue";
    }
}
