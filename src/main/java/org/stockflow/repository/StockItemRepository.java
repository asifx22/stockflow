package org.stockflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stockflow.entity.StockItem;

import java.util.List;
import java.util.Optional;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {

    Optional<StockItem> findByBarcode(String barcode);

    List<StockItem> findByIsActiveTrue();

    List<StockItem> findByIsFarmTrue();

    List<StockItem> findByOwnerId(Long ownerId);

}
