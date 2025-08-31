package org.stockflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
    private Integer quantity;
    private Integer unit;

    @JsonProperty("owner")
    private UserSummaryDto owner; // Use the safe DTO, not the UserEntity
}
