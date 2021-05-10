package com.capitole.ecommerce.entrypoints;

import com.capitole.ecommerce.core.entities.Price;
import com.capitole.ecommerce.core.usercases.GetPriceByBrandAndProductAndDate;
import com.capitole.ecommerce.entrypoints.responses.PriceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class PricesController {

    private static final Logger logger = LoggerFactory.getLogger(PricesController.class);
    private final GetPriceByBrandAndProductAndDate getPriceByBrandAndProductAndDate;

    public PricesController(GetPriceByBrandAndProductAndDate getPriceByBrandAndProductAndDate) {
        this.getPriceByBrandAndProductAndDate = getPriceByBrandAndProductAndDate;
    }

    @GetMapping("/brands/{brandId}/products/{productId}")
    public PriceResponse getPriceByBrandAndProductAndDate(
            @PathVariable Long brandId,
            @PathVariable Long productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Optional<LocalDateTime> date
    ) {
        logger.debug("[PricesController] call getPriceByBrandAndProductAndDate brand={} product={} date={} ", brandId, productId, date.orElse(LocalDateTime.now()));
        Price price = getPriceByBrandAndProductAndDate.execute(brandId, productId, date.orElse(LocalDateTime.now()));
        return new PriceResponse(
                price.getBrandId(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPriceList(),
                price.getProductId(),
                price.getPrice(),
                price.getCurr()
        );
    }
}
