package org.stockflow.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "stock_item")
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "isactive")
    private boolean isActive = true;

    @Enumerated(EnumType.STRING)
    private StockItemType type;          // Example: GOAT, FEED, MEDICINE

    private String category;      // Optional: Breed for goats, type for medicine, etc.

    private String barcode;       // Unique goat tag or item code

    private String gender;        // For goats only

    private Double weight;        // Optional (mostly for animals)

    private LocalDateTime entryDate;

    private String imageUrl;

    @Column(name = "isfarm")
    private boolean isFarm;

    private String description;

    private Integer quantity;

    private Integer unit;

    private LocalDateTime created;

    private String createdby;

    private LocalDateTime updated;

    private String updatedby;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;
}
