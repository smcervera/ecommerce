package com.capitole.ecommerce.config;

import com.capitole.ecommerce.core.repositories.GetPriceByBrandAndProductAndDateRepository;
import com.capitole.ecommerce.core.usercases.GetPriceByBrandAndProductAndDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesModule {

    @Bean
    public GetPriceByBrandAndProductAndDate getRate(GetPriceByBrandAndProductAndDateRepository getPriceByBrandAndProductAndDateRepository) {
        return new GetPriceByBrandAndProductAndDate(getPriceByBrandAndProductAndDateRepository);
    }
}
