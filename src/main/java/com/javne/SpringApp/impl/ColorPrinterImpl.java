package com.javne.SpringApp.impl;

import com.javne.SpringApp.BluePrinter;
import com.javne.SpringApp.ColorPrinter;
import com.javne.SpringApp.GreenPrinter;
import com.javne.SpringApp.RedPrinter;
import org.springframework.stereotype.Component;


@Component
public class ColorPrinterImpl implements ColorPrinter {

    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greenPrinter;

    public ColorPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;
    }

    @Override
    public String print() {
        return
                String.join(", ", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
    }
}
