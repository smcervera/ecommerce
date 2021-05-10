package com.capitole.ecommerce.unit.repositories;

import com.capitole.ecommerce.core.exceptions.PriceNotFoundException;
import com.capitole.ecommerce.core.entities.Price;
import com.capitole.ecommerce.core.repositories.GetPriceByBrandAndProductAndDateRepository;
import com.capitole.ecommerce.unit.repositories.utils.DateUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
public class GetPriceByBrandAndProductAndDateRepositoryImpl implements GetPriceByBrandAndProductAndDateRepository {

    private final String GET_PRODUCTS = "" +
            "SELECT brand_id, start_date, end_date, id, product_id, priority, price, curr FROM prices " +
            "WHERE product_id = ? AND brand_id = ? " +
            "AND start_date::datetime <= ? AND end_date::datetime >= ? " +
            "ORDER by priority DESC " +
            "LIMIT 1";

    private final JdbcTemplate jdbcTemplate;

    public GetPriceByBrandAndProductAndDateRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Price execute(Long brandId, Long productId, LocalDateTime date) {

        String dateString = DateUtils.formatToString(date);
        try {
            return jdbcTemplate.queryForObject(GET_PRODUCTS, new RowMapper<Price>() {

                @Override
                public Price mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Price(
                            rs.getLong(1),
                            rs.getTimestamp(2).toLocalDateTime(),
                            rs.getTimestamp(3).toLocalDateTime(),
                            rs.getLong(4),
                            rs.getLong(5),
                            rs.getLong(6),
                            rs.getDouble(7),
                            rs.getString(8)
                    );
                }
            }, productId, brandId, dateString, dateString);
        } catch (EmptyResultDataAccessException e) {
            throw new PriceNotFoundException(brandId, productId, dateString);
        }
    }
}
