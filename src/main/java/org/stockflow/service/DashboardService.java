package org.stockflow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stockflow.dto.DashboardSummaryDto;
import org.stockflow.enums.StockItemType;
import org.stockflow.repository.StockItemRepository;
import org.stockflow.repository.UserRepository;

@Service
public class DashboardService {

    @Autowired
    private StockItemRepository stockItemRepository;

    @Autowired
    private UserRepository userRepository;

    public DashboardSummaryDto getDashboardSummary() {
        DashboardSummaryDto dto = new DashboardSummaryDto();

        // Total users
       dto.setTotalUsers(userRepository.count());

        // Total stock items
        dto.setTotalStockItems(stockItemRepository.count());

        // Total active goats (filter by type = GOAT and isActive = true)
        dto.setActiveGoats(stockItemRepository.countByTypeAndIsActiveTrue(StockItemType.GOAT));



        return dto;
    }

}

