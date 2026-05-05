package org.TechStore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.TechStore.dto.request.MonitorRequest;
import org.TechStore.dto.response.MonitorResponse;
import org.TechStore.entity.Monitor;
import org.TechStore.exception.NotFoundException;
import org.TechStore.repository.MonitorRepository;
import org.TechStore.utility.MonitorMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MonitorService {
    private final MonitorRepository monitorRepository;

    public Page<MonitorResponse> getAll(Pageable pageable) {
        return monitorRepository.findAll(pageable)
                .map(MonitorMapper::toResponse);
    }

    public MonitorResponse getById(Long id) {
        Monitor monitor = monitorRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(" Id " + id + " not found "));
        return MonitorMapper.toResponse(monitor);
    }

    public MonitorResponse create(MonitorRequest request) {
        Monitor monitor = MonitorMapper.toEntity(request);
        Monitor saved = monitorRepository.save(monitor);
        return MonitorMapper.toResponse(saved);
    }

    public MonitorResponse update(Long id, MonitorRequest request) {

        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Monitor not found"));

        monitor.setName(request.getName());
        monitor.setManufacturer(request.getManufacturer());
        monitor.setDiagonal(request.getDiagonal());
        monitor.setPrice(request.getPrice());
        monitor.setSerialNumber(request.getSerialNumber());
        monitor.setQuantity(request.getQuantity());

        Monitor saved = monitorRepository.save(monitor);

        return MonitorMapper.toResponse(saved);
    }
}
