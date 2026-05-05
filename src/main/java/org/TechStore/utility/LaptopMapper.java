package org.TechStore.utility;

import lombok.experimental.UtilityClass;
import org.TechStore.dto.request.LaptopRequest;
import org.TechStore.dto.response.LaptopResponse;
import org.TechStore.entity.Laptop;

@UtilityClass
public class LaptopMapper {
    public LaptopResponse toResponse(Laptop laptop) {
        return LaptopResponse.builder()
                .id(laptop.getId())
                .name(laptop.getName())
                .price(laptop.getPrice())
                .manufacturer(laptop.getManufacturer())
                .quantity(laptop.getQuantity())
                .serialNumber(laptop.getSerialNumber())
                .screenSize(laptop.getScreenSize())
                .build();
    }
    public Laptop toEntity(LaptopRequest laptopRequest){
        return Laptop.builder()
                .name(laptopRequest.getName())
                .price(laptopRequest.getPrice())
                .manufacturer(laptopRequest.getManufacturer())
                .quantity(laptopRequest.getQuantity())
                .serialNumber(laptopRequest.getSerialNumber())
                .screenSize(laptopRequest.getScreenSize())
                .build();
    }

}
