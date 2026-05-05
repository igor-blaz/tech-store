package org.TechStore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.TechStore.enums.FormFactor;

import java.math.BigDecimal;

@Entity
@Table(name = "desktop_computers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DesktopComputer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "form_factor", nullable = false)
    private FormFactor formFactor;
}