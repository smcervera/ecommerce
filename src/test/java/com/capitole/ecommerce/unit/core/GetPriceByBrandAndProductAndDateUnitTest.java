package com.capitole.ecommerce.unit.core;

import com.capitole.ecommerce.core.entities.Price;
import com.capitole.ecommerce.core.exceptions.PriceNotFoundException;
import com.capitole.ecommerce.core.repositories.GetPriceByBrandAndProductAndDateRepository;
import com.capitole.ecommerce.core.usercases.GetPriceByBrandAndProductAndDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetPriceByBrandAndProductAndDateUnitTest {

    private GetPriceByBrandAndProductAndDate getPriceByBrandAndProductAndDate;
    private GetPriceByBrandAndProductAndDateRepository getPriceByBrandAndProductAndDateRepository;

    @BeforeAll
    public void setup() {
        getPriceByBrandAndProductAndDateRepository = mock(GetPriceByBrandAndProductAndDateRepository.class);
        getPriceByBrandAndProductAndDate = new GetPriceByBrandAndProductAndDate(getPriceByBrandAndProductAndDateRepository);
    }

    @Test
    public void when_execute_usercase_getPriceByBrandAndProductAndDate_return_object() {

        when(getPriceByBrandAndProductAndDateRepository
                .execute(eq(1L), eq(1L), any()))
                .thenReturn(new Price(1L, LocalDateTime.now(), LocalDateTime.now(), 1L, 1L, 1L, 10.0, "EUR"));

        Price result = getPriceByBrandAndProductAndDate.execute(1L, 1L, LocalDateTime.now());

        Assertions.assertNotNull(result);
    }

    @Test
    public void when_execute_usercase_getPriceByBrandAndProductAndDate_return_exception() {

        when(getPriceByBrandAndProductAndDateRepository
                .execute(eq(1L), eq(1L), any()))
                .thenThrow(PriceNotFoundException.class);

        Assertions.assertThrows(PriceNotFoundException.class, () -> {
            getPriceByBrandAndProductAndDate.execute(1L, 1L, LocalDateTime.now());
        });
    }

}
