package org.TechStore.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.TechStore.dto.request.DesktopComputerRequest;
import org.TechStore.dto.response.DesktopComputerResponse;
import org.TechStore.service.DesktopComputerService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/desktop-computers")
@RequiredArgsConstructor
public class DesktopComputerController {
    private final DesktopComputerService desktopComputerService;

    @GetMapping
    public Page<DesktopComputerResponse> getAll(
            @ParameterObject
            @PageableDefault(sort = "price") Pageable pageable) {
        return desktopComputerService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public DesktopComputerResponse getById(@PathVariable Long id) {
        return desktopComputerService.getById(id);
    }

    @PostMapping
    public ResponseEntity<DesktopComputerResponse> create(
            @Valid @RequestBody DesktopComputerRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(desktopComputerService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesktopComputerResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody DesktopComputerRequest request
    ) {
        return ResponseEntity.ok(desktopComputerService.update(id, request));
    }

}
