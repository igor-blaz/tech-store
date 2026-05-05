package org.TechStore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.TechStore.dto.request.HardDriveRequest;
import org.TechStore.dto.response.HardDriveResponse;
import org.TechStore.entity.HardDrive;
import org.TechStore.exception.NotFoundException;
import org.TechStore.repository.HardDriveRepository;
import org.TechStore.utility.HardDriveMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HardDriveService {
    private final HardDriveRepository hardDriveRepository;

    public Page<HardDriveResponse> getAll(Pageable pageable) {
        return hardDriveRepository.findAll(pageable)
                .map(HardDriveMapper::toResponse);
    }

    public HardDriveResponse getById(Long id) {
        HardDrive hardDrive = hardDriveRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(" Id " + id + " not found "));
        return HardDriveMapper.toResponse(hardDrive);
    }

    public HardDriveResponse create(HardDriveRequest request) {
        HardDrive hardDrive = HardDriveMapper.toEntity(request);
        HardDrive saved = hardDriveRepository.save(hardDrive);
        return HardDriveMapper.toResponse(saved);
    }

    public HardDriveResponse update(Long id, HardDriveRequest request) {

        HardDrive hardDrive = hardDriveRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("HardDrive not found"));

        hardDrive.setName(request.getName());
        hardDrive.setManufacturer(request.getManufacturer());
        hardDrive.setCapacity(request.getCapacity());
        hardDrive.setPrice(request.getPrice());
        hardDrive.setSerialNumber(request.getSerialNumber());
        hardDrive.setQuantity(request.getQuantity());

        HardDrive saved = hardDriveRepository.save(hardDrive);

        return HardDriveMapper.toResponse(saved);
    }
}
