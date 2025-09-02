package org.stockflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.stockflow.enums.StockItemType;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "id", "name", "type", "category", "barcode", "gender", "weight",
        "entryDate", "imageUrl", "farm", "description", "quantity", "unit", "owner"
})
public class StockItemDto {

    private Long id;

    @NotBlank(message = "Item name is required")
    @Size(min = 2, max = 50, message = "Item name must be between 2 and 50 characters")
    private String name;
    private StockItemType type;
    private String category;
    private String barcode;
    private String gender;
    private Double weight;
    private LocalDateTime entryDate;
    private String imageUrl;

    @JsonProperty("farm")
    private boolean isFarm;

    private String description;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    private Integer unit;

    @JsonProperty("owner")
    @NotNull(message = "Owner ID is required")
    private UserSummaryDto owner; // Use the safe DTO, not the UserEntity
}
