package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.LoaiChoDTO;
import com.project.tickettrainbooking.iservice.ILoaiChoService;
import com.project.tickettrainbooking.models.LoaiCho;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/loaicho")
public class LoaiChoController {
    private final ILoaiChoService loaiChoService;

    public LoaiChoController(ILoaiChoService loaiChoService) {
        this.loaiChoService = loaiChoService;
    }
    @PostMapping("")
    public ResponseEntity<?> creteLoaiCho(@Valid @RequestBody LoaiChoDTO loaiChoDTO){
        try {
            LoaiCho creteLoaiCho = loaiChoService.createLoaiCho(loaiChoDTO);
            return ResponseEntity.ok(creteLoaiCho);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi tạo loaijc cho: " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTauById(@PathVariable int id) {
        try {
            LoaiCho loaiCho = loaiChoService.getLoaiChoById(id);
            return ResponseEntity.ok(loaiCho);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không tìm thấy cho có ID: " + id);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<LoaiCho>> getAllTau() {
        List<LoaiCho> loaiChoList = loaiChoService.getAllLoaiCho();
        return ResponseEntity.ok(loaiChoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTau(@Valid @PathVariable int id, @RequestBody LoaiChoDTO loaiChoDTO) {
        try {
            LoaiCho updatedTau = loaiChoService.update(id, loaiChoDTO);
            return ResponseEntity.ok(updatedTau);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi cập nhật cho: " + e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTau(@PathVariable int id) {
        try {
            loaiChoService.deleteLoaiCho(id);
            return ResponseEntity.ok("Xóa tàu thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi xóa cho: " + e.getMessage());
        }
    }
}
