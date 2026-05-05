package org.TechStore.dto.request;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MonitorRequest {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String manufacturer;

    @NotNull
    @Positive
    @Digits(integer = 2, fraction = 1) // например 27.0, 32.5
    private BigDecimal diagonal;

    @NotNull
    @Positive
    @Digits(integer = 17, fraction = 2)
    private BigDecimal price;

    @NotBlank
    @Size(max = 255)
    private String serialNumber;

    @NotNull
    @Min(1)
    @Max(1_000_000)
    private Integer quantity;
}
