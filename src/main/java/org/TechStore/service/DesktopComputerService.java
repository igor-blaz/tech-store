package org.TechStore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.TechStore.dto.request.DesktopComputerRequest;
import org.TechStore.dto.response.DesktopComputerResponse;
import org.TechStore.entity.DesktopComputer;
import org.TechStore.exception.NotFoundException;
import org.TechStore.repository.DesktopComputerRepository;
import org.TechStore.utility.DesktopComputerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DesktopComputerService {
    private final DesktopComputerRepository desktopComputerRepository;

    public Page<DesktopComputerResponse> getAll(Pageable pageable) {
        return desktopComputerRepository.findAll(pageable)
                .map(DesktopComputerMapper::toResponse);
    }

    public DesktopComputerResponse getById(Long id) {
        DesktopComputer desktopComputer = desktopComputerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(" Id " + id + " not found "));
        return DesktopComputerMapper.toResponse(desktopComputer);
    }

    public DesktopComputerResponse create(DesktopComputerRequest request) {
        DesktopComputer desktopComputer = DesktopComputerMapper.toEntity(request);
        DesktopComputer saved = desktopComputerRepository.save(desktopComputer);
        return DesktopComputerMapper.toResponse(saved);
    }

    public DesktopComputerResponse update(Long id, DesktopComputerRequest request) {

        DesktopComputer desktopComputer = desktopComputerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Desktop computer not found"));

        desktopComputer.setName(request.getName());
        desktopComputer.setManufacturer(request.getManufacturer());
        desktopComputer.setFormFactor(request.getFormFactor());
        desktopComputer.setPrice(request.getPrice());
        desktopComputer.setSerialNumber(request.getSerialNumber());
        desktopComputer.setQuantity(request.getQuantity());

        DesktopComputer saved = desktopComputerRepository.save(desktopComputer);

        return DesktopComputerMapper.toResponse(saved);
    }
}
