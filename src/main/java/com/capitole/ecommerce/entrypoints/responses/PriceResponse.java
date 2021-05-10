package com.capitole.ecommerce.entrypoints.responses;

import java.time.LocalDateTime;

public class PriceResponse {

    private final Long brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Long priceList;
    private final Long productId;
    private final Double price;
    private final String curr;

    public PriceResponse(
            Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId, Double price, String curr
    ) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.price = price;
        this.curr = curr;
    }

    public Long getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurr() {
        return curr;
    }
}
