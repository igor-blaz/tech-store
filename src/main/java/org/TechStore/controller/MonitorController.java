package org.TechStore.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.TechStore.dto.request.MonitorRequest;
import org.TechStore.dto.response.MonitorResponse;
import org.TechStore.service.MonitorService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/monitors")
@RequiredArgsConstructor
public class MonitorController {
    private final MonitorService monitorService;

    @GetMapping
    public Page<MonitorResponse> getAll(
            @ParameterObject
            @PageableDefault(sort = "price") Pageable pageable) {
        return monitorService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public MonitorResponse getById(@PathVariable Long id) {
        return monitorService.getById(id);
    }

    @PostMapping
    public ResponseEntity<MonitorResponse> create(
            @Valid @RequestBody MonitorRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(monitorService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitorResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody MonitorRequest request
    ) {
        return ResponseEntity.ok(monitorService.update(id, request));
    }
}
