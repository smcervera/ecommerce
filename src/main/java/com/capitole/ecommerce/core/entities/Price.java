package com.capitole.ecommerce.core.entities;

import java.time.LocalDateTime;

public class Price {

    private final Long brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Long priceList;
    private final Long productId;
    private final Long priority;
    private final Double price;
    private final String curr;

    public Price(Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId, Long priority, Double price, String curr) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
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

    public Long getPriority() {
        return priority;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurr() {
        return curr;
    }
}
