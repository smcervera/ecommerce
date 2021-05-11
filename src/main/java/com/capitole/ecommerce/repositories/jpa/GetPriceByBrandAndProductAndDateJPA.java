package com.capitole.ecommerce.repositories.jpa;

import com.capitole.ecommerce.repositories.model.PriceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface GetPriceByBrandAndProductAndDateJPA extends JpaRepository<PriceModel, Long> {

    @Query("SELECT p FROM PriceModel p WHERE p.productId = :productId AND p.brandId = :brandId AND p.startDate <= :date AND p.endDate >= :date ORDER by p.priority DESC")
    List<PriceModel> execute(Long brandId, Long productId, LocalDateTime date);

}
