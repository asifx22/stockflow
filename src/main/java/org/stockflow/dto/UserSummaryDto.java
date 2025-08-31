package org.stockflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSummaryDto {
    private long id;
    private String username;
    // Add any other SAFE fields you want to show, like 'firstname'
}