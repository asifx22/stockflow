package org.stockflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stockflow.entity.StockItem;
import org.stockflow.enums.StockItemType;

import java.util.List;
import java.util.Optional;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {

    Optional<StockItem> findByBarcode(String barcode);

    List<StockItem> findByIsActiveTrue();

    List<StockItem> findByIsFarmTrue();

    List<StockItem> findByOwnerId(Long ownerId);

    boolean existsByOwnerId(Long ownerId);

    long countByType(StockItemType type);             // For individual type counts
    long countByTypeAndIsActiveTrue(StockItemType type); // For active goats
    long count();                                     // For total stock items
    long countByIsActiveTrue();                       // For total active stock

}
