package org.TechStore.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.TechStore.dto.request.LaptopRequest;
import org.TechStore.dto.response.LaptopResponse;
import org.TechStore.service.LaptopService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/laptops")
@RequiredArgsConstructor
public class LaptopController {
    private final LaptopService laptopService;

    @GetMapping
    public Page<LaptopResponse> getAll(
            @ParameterObject
            @PageableDefault(sort = "price") Pageable pageable) {
        return laptopService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public LaptopResponse getById(@PathVariable Long id) {
        return laptopService.getById(id);
    }

    @PostMapping
    public ResponseEntity<LaptopResponse> create(
            @Valid @RequestBody LaptopRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(laptopService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaptopResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody LaptopRequest request
    ) {
        return ResponseEntity.ok(laptopService.update(id, request));
    }
}
