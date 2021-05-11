package com.capitole.ecommerce.repositories;

import com.capitole.ecommerce.core.entities.Price;
import com.capitole.ecommerce.core.exceptions.PriceNotFoundException;
import com.capitole.ecommerce.core.repositories.GetPriceByBrandAndProductAndDateRepository;
import com.capitole.ecommerce.repositories.jpa.GetPriceByBrandAndProductAndDateJPA;
import com.capitole.ecommerce.repositories.model.PriceModel;
import com.capitole.ecommerce.repositories.utils.DateUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class GetPriceByBrandAndProductAndDateRepositoryImpl implements GetPriceByBrandAndProductAndDateRepository {

    private final GetPriceByBrandAndProductAndDateJPA getPriceByBrandAndProductAndDateJPA;

    public GetPriceByBrandAndProductAndDateRepositoryImpl(GetPriceByBrandAndProductAndDateJPA getPriceByBrandAndProductAndDateJPA) {
        this.getPriceByBrandAndProductAndDateJPA = getPriceByBrandAndProductAndDateJPA;
    }

    @Override
    public Price execute(Long brandId, Long productId, LocalDateTime date) {
        List<PriceModel> price = getPriceByBrandAndProductAndDateJPA.execute(brandId, productId, date);

        return price.stream().map(p -> new Price(
                p.getBrandId(),
                p.getStartDate(),
                p.getEndDate(),
                p.getPriceList(),
                p.getProductId(),
                p.getPriority(),
                p.getPrice(),
                p.getCurr()
        )).findFirst()
                .orElseThrow(() -> new PriceNotFoundException(brandId, productId, DateUtils.formatToString(date)));
    }
}