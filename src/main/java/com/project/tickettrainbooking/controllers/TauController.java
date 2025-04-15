package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.TauDTO;
import com.project.tickettrainbooking.iservice.ITauService;
import com.project.tickettrainbooking.models.Tau;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tau")
public class TauController {
    private final ITauService tauService;

    public TauController(ITauService tauService) {
        this.tauService = tauService;
    }

    @PostMapping("")
    public ResponseEntity<?> createTau(@Valid @RequestBody TauDTO tauDTO){

        try {
            Tau createdTau = tauService.createTau(tauDTO);
            return ResponseEntity.ok(createdTau);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi tạo tàu: " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTauById(@PathVariable int id) {
        try {
            Tau tau = tauService.getTauById(id);
            return ResponseEntity.ok(tau);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không tìm thấy tàu có ID: " + id);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Tau>> getAllTau() {
        List<Tau> tauList = tauService.getAllTau();
        return ResponseEntity.ok(tauList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTau(@PathVariable int id, @RequestBody TauDTO tauDTO) {
        try {
            Tau updatedTau = tauService.updateTau(id, tauDTO);
            return ResponseEntity.ok(updatedTau);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi cập nhật tàu: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTau(@PathVariable int id) {
        try {
            tauService.deleteTau(id);
            return ResponseEntity.ok("Xóa tàu thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi xóa tàu: " + e.getMessage());
        }
    }
}
