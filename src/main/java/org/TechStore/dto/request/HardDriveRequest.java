package org.TechStore.dto.request;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class HardDriveRequest {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String manufacturer;

    @NotNull
    @Min(1)
    private Integer capacity;

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
