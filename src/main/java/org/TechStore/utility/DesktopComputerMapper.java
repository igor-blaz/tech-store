package org.TechStore.utility;

import lombok.experimental.UtilityClass;
import org.TechStore.dto.request.DesktopComputerRequest;
import org.TechStore.dto.response.DesktopComputerResponse;
import org.TechStore.entity.DesktopComputer;

@UtilityClass
public class DesktopComputerMapper {
    public DesktopComputerResponse toResponse(DesktopComputer desktopComputer) {
        return DesktopComputerResponse.builder()
                .id(desktopComputer.getId())
                .name(desktopComputer.getName())
                .price(desktopComputer.getPrice())
                .manufacturer(desktopComputer.getManufacturer())
                .quantity(desktopComputer.getQuantity())
                .serialNumber(desktopComputer.getSerialNumber())
                .formFactor(desktopComputer.getFormFactor())
                .build();
    }
    public DesktopComputer toEntity(DesktopComputerRequest request){
        return DesktopComputer.builder()
                .name(request.getName())
                .price(request.getPrice())
                .manufacturer(request.getManufacturer())
                .quantity(request.getQuantity())
                .serialNumber(request.getSerialNumber())
                .formFactor(request.getFormFactor())
                .build();
    }
}
