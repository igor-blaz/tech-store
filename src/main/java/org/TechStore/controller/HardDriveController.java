package org.TechStore.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.TechStore.dto.request.HardDriveRequest;
import org.TechStore.dto.response.HardDriveResponse;
import org.TechStore.service.HardDriveService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/hard-drives")
@RequiredArgsConstructor
public class HardDriveController {
    private final HardDriveService hardDriveService;

    @GetMapping
    public Page<HardDriveResponse> getAll(
            @ParameterObject
            @PageableDefault(sort = "price") Pageable pageable) {
        return hardDriveService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public HardDriveResponse getById(@PathVariable Long id) {
        return hardDriveService.getById(id);
    }

    @PostMapping
    public ResponseEntity<HardDriveResponse> create(
            @Valid @RequestBody HardDriveRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hardDriveService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardDriveResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody HardDriveRequest request
    ) {
        return ResponseEntity.ok(hardDriveService.update(id, request));
    }
}
