package com.capitole.ecommerce.core.repositories;

import com.capitole.ecommerce.core.entities.Price;

import java.time.LocalDateTime;

public interface GetPriceByBrandAndProductAndDateRepository {

    Price execute(Long brandId, Long productId, LocalDateTime date);
}
