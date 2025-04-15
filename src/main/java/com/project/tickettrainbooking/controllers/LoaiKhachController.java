package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.LoaiKhachDTO;
import com.project.tickettrainbooking.iservice.ILoaiKhachService;
import com.project.tickettrainbooking.models.LoaiKhach;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/loaikhach")
public class LoaiKhachController {
    private final ILoaiKhachService loaiKhachService;

    public LoaiKhachController(ILoaiKhachService loaiKhachService) {
        this.loaiKhachService = loaiKhachService;
    }

    @PostMapping("")
    public ResponseEntity<?> createLoaiKhach(@RequestBody LoaiKhachDTO loaiKhachDTO) {
        try {
            LoaiKhach createdLoaiKhach = loaiKhachService.createLoaiKhach(loaiKhachDTO);
            return ResponseEntity.ok(createdLoaiKhach);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi tạo loại khách: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLoaiKhachById(@PathVariable int id) {
        try {
            LoaiKhach loaiKhach = loaiKhachService.getLoaiKhachById(id);
            return ResponseEntity.ok(loaiKhach);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không tìm thấy loại khách có ID: " + id);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<LoaiKhach>> getAllLoaiKhach() {
        List<LoaiKhach> loaiKhachList = loaiKhachService.getAllLoaiKhach();
        return ResponseEntity.ok(loaiKhachList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoaiKhach(@PathVariable int id, @RequestBody LoaiKhachDTO loaiKhachDTO) {
        try {
            LoaiKhach updatedLoaiKhach = loaiKhachService.updateLoaiKhach(id, loaiKhachDTO);
            return ResponseEntity.ok(updatedLoaiKhach);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi cập nhật loại khách: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLoaiKhach(@PathVariable int id) {
        try {
            loaiKhachService.deleteLoaiKhach(id);
            return ResponseEntity.ok("Xóa loại khách thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi xóa loại khách: " + e.getMessage());
        }
    }

}
