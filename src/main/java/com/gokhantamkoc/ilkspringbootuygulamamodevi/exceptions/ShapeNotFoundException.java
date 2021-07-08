package com.gokhantamkoc.ilkspringbootuygulamamodevi.exceptions;

public class ShapeNotFoundException extends NotFoundException {
    public ShapeNotFoundException(int id) {
        super(String.format("Ürün Bulunamadı (id => %s)", id));
    }
}