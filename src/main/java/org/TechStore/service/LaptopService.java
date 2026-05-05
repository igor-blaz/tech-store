package org.TechStore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.TechStore.dto.request.LaptopRequest;
import org.TechStore.dto.response.LaptopResponse;
import org.TechStore.entity.Laptop;
import org.TechStore.exception.NotFoundException;
import org.TechStore.repository.LaptopRepository;
import org.TechStore.utility.LaptopMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public Page<LaptopResponse> getAll(Pageable pageable) {
        return laptopRepository.findAll(pageable)
                .map(LaptopMapper::toResponse);
    }

    public LaptopResponse getById(Long id) {
        Laptop laptop = laptopRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(" Id " + id + " not found "));
        return LaptopMapper.toResponse(laptop);
    }
    
    public LaptopResponse create(LaptopRequest request) {
        Laptop laptop = LaptopMapper.toEntity(request);
        Laptop saved = laptopRepository.save(laptop);
        return LaptopMapper.toResponse(saved);
    }

    public LaptopResponse update(Long id, LaptopRequest request) {

        Laptop laptop = laptopRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Laptop not found"));

        laptop.setName(request.getName());
        laptop.setManufacturer(request.getManufacturer());
        laptop.setScreenSize(request.getScreenSize());
        laptop.setPrice(request.getPrice());
        laptop.setSerialNumber(request.getSerialNumber());
        laptop.setQuantity(request.getQuantity());

        Laptop saved = laptopRepository.save(laptop);

        return LaptopMapper.toResponse(saved);
    }

}
