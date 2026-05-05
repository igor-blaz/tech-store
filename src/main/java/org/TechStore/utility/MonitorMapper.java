package org.TechStore.utility;

import lombok.experimental.UtilityClass;
import org.TechStore.dto.request.MonitorRequest;
import org.TechStore.dto.response.MonitorResponse;
import org.TechStore.entity.Monitor;

@UtilityClass
public class MonitorMapper {
    public MonitorResponse toResponse(Monitor monitor){
        return MonitorResponse.builder()
                .id(monitor.getId())
                .name(monitor.getName())
                .manufacturer(monitor.getManufacturer())
                .serialNumber(monitor.getSerialNumber())
                .quantity(monitor.getQuantity())
                .diagonal(monitor.getDiagonal())
                .price(monitor.getPrice())
                .build();
    }
    public Monitor toEntity(MonitorRequest monitorRequest){
        return Monitor.builder()
                .name(monitorRequest.getName())
                .manufacturer(monitorRequest.getManufacturer())
                .serialNumber(monitorRequest.getSerialNumber())
                .quantity(monitorRequest.getQuantity())
                .diagonal(monitorRequest.getDiagonal())
                .price(monitorRequest.getPrice())
                .build();
    }
}
