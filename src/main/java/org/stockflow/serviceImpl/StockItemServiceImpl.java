package org.stockflow.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stockflow.dto.StockItemDto;
import org.stockflow.entity.StockItem;
import org.stockflow.entity.UserEntity;
import org.stockflow.mapper.StockItemMapper;
import org.stockflow.repository.StockItemRepository;
import org.stockflow.repository.UserRepository;
import org.stockflow.service.StockItemService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockItemServiceImpl implements StockItemService {

    @Autowired
    private StockItemRepository stockItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public StockItemDto saveItem(StockItemDto item) {
        StockItem stockItem = StockItemMapper.toEntity(item);
        if (stockItem.getBarcode() == null || stockItem.getBarcode().isEmpty()) {
            String year = String.valueOf(LocalDateTime.now().getDayOfYear());
            String random = java.util.UUID.randomUUID().toString().substring(0, 6).toUpperCase();
            stockItem.setBarcode(stockItem.getType() + "-" + year + "-" + random);
        }
        StockItem saved = stockItemRepository.save(stockItem);

        return StockItemMapper.toDto(saved);

    }

    @Override
    public List<StockItemDto> getAllItems() {
        return stockItemRepository.findAll()
                .stream()
                .map(StockItemMapper::toDto)
                .toList();
    }

    @Override
    public StockItemDto getItemById(Long id) {
        StockItem stockItem = stockItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
        return StockItemMapper.toDto(stockItem);
    }

    @Override
    public StockItemDto getItemByBarcode(String barcode) {
        StockItem stockItem = stockItemRepository.findByBarcode(barcode)
                .orElseThrow(() -> new RuntimeException("Item not found with barcode: " + barcode));
        return StockItemMapper.toDto(stockItem);
    }

    @Override
    public StockItemDto updateItem(Long id, StockItemDto dto) {
        StockItem existing = stockItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot update. Item not found with ID: " + id));

        // 🔁 Update the fields
        existing.setName(dto.getName());
        existing.setType(dto.getType());
        existing.setCategory(dto.getCategory());
        existing.setBarcode(dto.getBarcode());
        existing.setGender(dto.getGender());
        existing.setWeight(dto.getWeight());
        existing.setEntryDate(dto.getEntryDate());
        existing.setImageUrl(dto.getImageUrl());
        existing.setFarm(dto.isFarm());
        existing.setDescription(dto.getDescription());
        existing.setUnit(dto.getUnit());
        existing.setQuantity(dto.getQuantity());

        StockItem updated = stockItemRepository.save(existing);
        return StockItemMapper.toDto(updated);
    }

    @Override
    public void deleteItem(Long id) {
        if (!stockItemRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Item not found with ID: " + id);
        }
        stockItemRepository.deleteById(id);
    }

    @Override
    public List<StockItemDto> filterItems(String type, String category, String gender) {
        List<StockItem> filtered = stockItemRepository.findAll().stream()
                .filter(item -> type == null)
                .filter(item -> category == null || item.getCategory().equalsIgnoreCase(category))
                .filter(item -> gender == null || item.getGender().equalsIgnoreCase(gender))
                .toList();

        return filtered.stream()
                .map(StockItemMapper::toDto)
                .toList();
    }


    @Override
    public void toggleActive(Long id) {
        StockItem item = stockItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
        item.setActive(!item.isActive());
        stockItemRepository.save(item);
    }


    @Override
    public List<StockItemDto> getActiveItems() {
        return stockItemRepository.findByIsActiveTrue().stream()
                .map(StockItemMapper::toDto)
                .toList();
    }

    @Override
    public List<StockItemDto> getFarmItems() {
        return stockItemRepository.findByIsFarmTrue().stream()
                .map(StockItemMapper::toDto)
                .toList();
    }

    @Override
    public List<StockItemDto> getStockItemByUser(Long id) {
        List<StockItem> stockItem = stockItemRepository.findByOwnerId(id);
        List<StockItemDto> stockItemDto = new ArrayList<>();

        for (StockItem stock : stockItem) {
            stockItemDto.add(StockItemMapper.toDto(stock));
        }
        return stockItemDto;
    }


    @Override
    public StockItemDto reassignOwner(Long itemId, Long ownerId) {
        StockItem stockItem = stockItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        UserEntity owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        stockItem.setOwner(owner);
        return StockItemMapper.toDto(stockItemRepository.save(stockItem));
    }

    @Override
    public boolean existsOwner(Long ownerId) {
        
        return stockItemRepository.existsByOwnerId(ownerId);
    }

}
