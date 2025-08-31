package org.stockflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.stockflow.dto.StockItemDto;
import org.stockflow.service.StockItemService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/items")
public class StockItemController {

    @Autowired
    private StockItemService stockItemService;

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody StockItemDto item) {
        stockItemService.saveItem(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StockItemDto>> getAllItems() {
        return ResponseEntity.ok(stockItemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockItemDto> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(stockItemService.getItemById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockItemDto> updateItem(@PathVariable Long id, @RequestBody StockItemDto updatedItem) {
        return ResponseEntity.ok(stockItemService.updateItem(id, updatedItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        stockItemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<StockItemDto>> filterItems(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String gender) {
        return ResponseEntity.ok(stockItemService.filterItems(type, category, gender));
    }

    @PatchMapping("/{id}/toggle-active")
    public ResponseEntity<Void> toggleActiveStatus(@PathVariable Long id) {
        stockItemService.toggleActive(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<StockItemDto>> getActiveItems() {
        return ResponseEntity.ok(stockItemService.getActiveItems());
    }

    @GetMapping("/farm")
    public ResponseEntity<List<StockItemDto>> getFarmItems() {
        return ResponseEntity.ok(stockItemService.getFarmItems());
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<StockItemDto> getByBarcode(@PathVariable String barcode) {
        return ResponseEntity.ok(stockItemService.getItemByBarcode(barcode));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<StockItemDto>> getUserStock(@PathVariable("id") Long id) {
        List<StockItemDto> stockItemByUser = stockItemService.getStockItemByUser(id);
        return new ResponseEntity<>(stockItemByUser, HttpStatus.FOUND);
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String uploadDir = "uploads/stock-items/";
            String originalFilename = file.getOriginalFilename();
            String fileName = UUID.randomUUID() + "_" + originalFilename;
            Path filePath = Paths.get(uploadDir + fileName);

            // Create directory if not exists
            Files.createDirectories(filePath.getParent());
            Files.copy(file.getInputStream(), filePath);

            String imageUrl = "/files/stock-items/" + fileName;
            return ResponseEntity.ok(imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

}
