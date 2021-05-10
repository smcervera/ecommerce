package com.capitole.ecommerce.unit.repositories;

import com.capitole.ecommerce.core.entities.Price;
import com.capitole.ecommerce.core.exceptions.PriceNotFoundException;
import com.capitole.ecommerce.core.repositories.GetPriceByBrandAndProductAndDateRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetPriceByBrandAndProductAndDateRepositoryImplTest {

    private JdbcTemplate jdbcTemplate;
    private EmbeddedDatabase db;

    private GetPriceByBrandAndProductAndDateRepository repository;

    @BeforeEach
    public void setup() {

        db = new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScripts(
                    "db/migration/V202105070000__init_db_dml.sql",
                    "db/migration/V202105070001__init_db_ddl.sql"
                )
                .build();

        jdbcTemplate = new JdbcTemplate(db);
        repository = new GetPriceByBrandAndProductAndDateRepositoryImpl(jdbcTemplate);

    }

    @AfterEach
    public void after() {
        db.shutdown();
    }

    @Test
    public void give_product_brand_date_return_price() {

        LocalDateTime time = LocalDateTime.parse("2020-06-14 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Price result = repository.execute(1L, 35455L, time);
        Assertions.assertEquals(35.5, result.getPrice());
        Assertions.assertEquals(1, result.getPriceList());
    }

    @Test
    public void give_product_brand_date_return_not_found() {

        Assertions.assertThrows(PriceNotFoundException.class, () -> {
            repository.execute(1L, 2L, LocalDateTime.now());
        });
    }
}
