package com.capitole.ecommerce.core.exceptions;

public class PriceNotFoundException extends RuntimeException{

    private final Long brand;
    private final Long product;
    private final String date;

    public PriceNotFoundException(Long brand, Long product, String date) {
        super();
        this.brand = brand;
        this.product = product;
        this.date = date;
    }

    @Override
    public String toString() {
        return "brand=" + brand +
                ", product=" + product +
                ", date=" + date;
    }
}
