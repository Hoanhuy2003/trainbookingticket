package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.GaTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IGaTauService;
import com.project.tickettrainbooking.models.GaTau;
import com.project.tickettrainbooking.responses.GaTauResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/gatau")
public class GaTauController {
    private final IGaTauService gaTauService;

    public GaTauController(IGaTauService gaTauService) {
        this.gaTauService = gaTauService;
    }

    @PostMapping("")
    public ResponseEntity<?> createGaTau(@Valid @RequestBody GaTauDTO gaTauDTO){

        try {
            GaTau newGaTau = gaTauService.createGaTau(gaTauDTO);
            return ResponseEntity.ok().body(GaTauResponse.fromGaTau(newGaTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ Lấy thông tin Ga Tàu theo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getGaTauById(@PathVariable("id") Integer id) {
        try {
            GaTau gaTau = gaTauService.getGaTauById(id);
            return ResponseEntity.ok().body(GaTauResponse.fromGaTau(gaTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ Lấy danh sách tất cả Ga Tàu
    @GetMapping("")
    public ResponseEntity<List<GaTauResponse>> getAllGaTau() {
        List<GaTau> gaTaus = gaTauService.getAllGaTau();
        List<GaTauResponse> responses = gaTaus.stream()
                .map(GaTauResponse::fromGaTau)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGaTau(@PathVariable("id") Integer id, @Valid @RequestBody GaTauDTO gaTauDTO) {
        try {
            GaTau updatedGaTau = gaTauService.updateGaTau(id, gaTauDTO);
            return ResponseEntity.ok().body(GaTauResponse.fromGaTau(updatedGaTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGaTau(@PathVariable("id") Integer id) {
        try {
            gaTauService.deleteGaTau(id);
            return ResponseEntity.ok().body("Xóa thành công Ga có ID: " + id);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
