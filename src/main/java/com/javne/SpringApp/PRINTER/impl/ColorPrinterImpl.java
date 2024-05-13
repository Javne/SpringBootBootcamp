package com.javne.SpringApp.PRINTER.impl;

import com.javne.SpringApp.PRINTER.BluePrinter;
import com.javne.SpringApp.PRINTER.ColorPrinter;
import com.javne.SpringApp.PRINTER.GreenPrinter;
import com.javne.SpringApp.PRINTER.RedPrinter;
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
