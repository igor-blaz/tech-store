package org.TechStore.utility;

import lombok.experimental.UtilityClass;
import org.TechStore.dto.request.HardDriveRequest;
import org.TechStore.dto.response.HardDriveResponse;
import org.TechStore.entity.HardDrive;

@UtilityClass
public class HardDriveMapper {
    public HardDriveResponse toResponse(HardDrive hardDrive) {
        return HardDriveResponse.builder()
                .id(hardDrive.getId())
                .name(hardDrive.getName())
                .price(hardDrive.getPrice())
                .manufacturer(hardDrive.getManufacturer())
                .quantity(hardDrive.getQuantity())
                .serialNumber(hardDrive.getSerialNumber())
                .capacity(hardDrive.getCapacity())
                .build();
    }
    public HardDrive toEntity(HardDriveRequest hardDriveRequest){
        return HardDrive.builder()
                .name(hardDriveRequest.getName())
                .price(hardDriveRequest.getPrice())
                .manufacturer(hardDriveRequest.getManufacturer())
                .quantity(hardDriveRequest.getQuantity())
                .serialNumber(hardDriveRequest.getSerialNumber())
                .capacity(hardDriveRequest.getCapacity())
                .build();
    }

}
