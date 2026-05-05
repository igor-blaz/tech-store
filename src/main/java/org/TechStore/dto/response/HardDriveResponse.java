package org.TechStore.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class HardDriveResponse {
    private Long id;
    private String name;
    private String manufacturer;
    private Integer capacity;
    private BigDecimal price;
    private String serialNumber;
    private Integer quantity;
}