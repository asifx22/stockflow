package org.stockflow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardSummaryDto {
    private long totalUsers;
    private long totalStockItems;
    private long activeGoats;
    private Map<String, Long> stockByType;
}
