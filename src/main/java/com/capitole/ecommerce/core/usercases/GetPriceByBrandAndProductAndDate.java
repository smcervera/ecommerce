package com.capitole.ecommerce.core.usercases;

import com.capitole.ecommerce.core.entities.Price;
import com.capitole.ecommerce.core.repositories.GetPriceByBrandAndProductAndDateRepository;

import java.time.LocalDateTime;

public class GetPriceByBrandAndProductAndDate {

    private final GetPriceByBrandAndProductAndDateRepository getPriceByBrandAndProductAndDateRepository;

    public GetPriceByBrandAndProductAndDate(
            GetPriceByBrandAndProductAndDateRepository getPriceByBrandAndProductAndDateRepository
    ) {
        this.getPriceByBrandAndProductAndDateRepository = getPriceByBrandAndProductAndDateRepository;
    }

    public Price execute(Long brandId, Long productId, LocalDateTime date) {
        return getPriceByBrandAndProductAndDateRepository.execute(brandId, productId, date);
    }
}
