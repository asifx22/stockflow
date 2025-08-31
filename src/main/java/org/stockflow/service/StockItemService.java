package org.stockflow.service;

import org.stockflow.dto.StockItemDto;

import java.util.List;

public interface StockItemService {

    // 🔹 Create
    void saveItem(StockItemDto item);

    // 🔹 Read
    List<StockItemDto> getAllItems();

    StockItemDto getItemById(Long id);

    StockItemDto getItemByBarcode(String barcode);

    // 🔹 Update
    StockItemDto updateItem(Long id, StockItemDto dto);

    // 🔹 Delete
    void deleteItem(Long id);

    List<StockItemDto> filterItems(String type, String category, String gender);


    void toggleActive(Long id);


    List<StockItemDto> getActiveItems();


    List<StockItemDto> getFarmItems();


    List<StockItemDto> getStockItemByUser(Long id);


}
