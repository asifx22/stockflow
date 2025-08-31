package org.stockflow.mapper;

import org.stockflow.dto.StockItemDto;
import org.stockflow.dto.UserSummaryDto;
import org.stockflow.entity.StockItem;
import org.stockflow.entity.UserEntity;

public class StockItemMapper {

    public static StockItemDto toDto(StockItem stockItem) {


        StockItemDto dto = new StockItemDto();
        dto.setId(stockItem.getId());
        dto.setCategory(stockItem.getCategory());
        dto.setBarcode(stockItem.getBarcode());
        dto.setGender(stockItem.getGender());
        dto.setName(stockItem.getName());
        dto.setType(stockItem.getType());
        dto.setFarm(stockItem.isFarm());
        dto.setDescription(stockItem.getDescription());
        dto.setUnit(stockItem.getUnit());
        dto.setQuantity(stockItem.getQuantity());
        dto.setImageUrl(stockItem.getImageUrl());
        dto.setEntryDate(stockItem.getEntryDate()); // This was also missing
        dto.setWeight(stockItem.getWeight());       // This was also missing
        if (stockItem.getOwner() != null) {
            UserSummaryDto ownerDto = new UserSummaryDto();
            ownerDto.setId(stockItem.getOwner().getId());
            ownerDto.setUsername(stockItem.getOwner().getUsername());
            dto.setOwner(ownerDto);
        }
        return dto;
    }


    public static StockItem toEntity(StockItemDto dto) {
        StockItem stockItem = new StockItem();
        stockItem.setId(dto.getId());
        stockItem.setCategory(dto.getCategory());
        stockItem.setBarcode(dto.getBarcode());
        stockItem.setGender(dto.getGender());
        stockItem.setName(dto.getName());
        stockItem.setType(dto.getType());
        stockItem.setFarm(dto.isFarm());
        stockItem.setDescription(dto.getDescription());
        stockItem.setUnit(dto.getUnit());
        stockItem.setQuantity(dto.getQuantity());
        stockItem.setEntryDate(dto.getEntryDate());
        stockItem.setWeight(dto.getWeight());
        stockItem.setImageUrl(dto.getImageUrl());
        if (dto.getOwner() != null && dto.getOwner().getId() > 0) {
            UserEntity ownerEntity = new UserEntity();
            ownerEntity.setId(dto.getOwner().getId());
            stockItem.setOwner(ownerEntity);
        }

        return stockItem;
    }
}
