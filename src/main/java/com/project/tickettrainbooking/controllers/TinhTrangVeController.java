package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.TinhTrangVeDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.ITinhTrangVeService;
import com.project.tickettrainbooking.models.TinhTrangVe;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tinhtrangve")
public class TinhTrangVeController {
    private final ITinhTrangVeService tinhTrangVeService;

    public TinhTrangVeController(ITinhTrangVeService tinhTrangVeService) {
        this.tinhTrangVeService = tinhTrangVeService;
    }

    @PostMapping("")
    public ResponseEntity<?> createTinhTrang(@Valid @RequestBody TinhTrangVeDTO tinhTrangVeDTO){
        try {
            TinhTrangVe tinhTrangVe = tinhTrangVeService.createTinhTrang(tinhTrangVeDTO);
            return ResponseEntity.ok(tinhTrangVe);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body("Lỗi khi tạo : " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTinhTrangById(@PathVariable int id){
        try {
            TinhTrangVe tinhTrangVe = tinhTrangVeService.getTinhTrangById(id);
            return ResponseEntity.ok(tinhTrangVe);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body("Không tìm thấy  có ID: " + id);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<TinhTrangVe>> getAllTinhTrang() {
        List<TinhTrangVe> tinhTrangVeList = tinhTrangVeService.getAll();
        return ResponseEntity.ok(tinhTrangVeList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTinhTrang(@PathVariable Integer id, @RequestBody TinhTrangVeDTO tinhTrangVeDTO) {
        try {
            TinhTrangVe tinhTrangVe = tinhTrangVeService.update(id, tinhTrangVeDTO);
            return ResponseEntity.ok(tinhTrangVe);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi cập nhật loại khách: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLoaiKhach(@PathVariable Integer id) {
        try {
            tinhTrangVeService.delete(id);
            return ResponseEntity.ok("Xóa loại khách thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi xóa loại khách: " + e.getMessage());
        }
    }
}
