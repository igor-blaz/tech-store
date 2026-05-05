package org.TechStore.dto.response;

import lombok.Builder;
import lombok.Data;
import org.TechStore.enums.FormFactor;

import java.math.BigDecimal;

@Data
@Builder
public class DesktopComputerResponse {
    private Long id;
    private String name;
    private String manufacturer;
    private FormFactor formFactor;
    private BigDecimal price;
    private String serialNumber;
    private Integer quantity;
}
