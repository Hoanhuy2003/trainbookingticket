package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.ThanhToanDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IThanhToanService;
import com.project.tickettrainbooking.models.ThanhToan;
import com.project.tickettrainbooking.responses.ThanhToanResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/thanhtoan")

public class ThanhToanController {

    private final IThanhToanService thanhToanService;

    public ThanhToanController(IThanhToanService thanhToanService) {
        this.thanhToanService = thanhToanService;
    }

    @PostMapping("")
    public ResponseEntity<?> createThanhToan(@Valid @RequestBody ThanhToanDTO thanhToanDTO){
        try {
            ThanhToan thanhToan = thanhToanService.createThanhToan(thanhToanDTO);
            return ResponseEntity.ok().body(ThanhToanResponse.fromThanhToan(thanhToan));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body("Lỗi tạo thanh toán: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> confirmThanhToan(@PathVariable("id") int id){
        try {
            ThanhToan thanhToan = thanhToanService.confirmThanhToan(id);
            return ResponseEntity.ok().body(ThanhToanResponse.fromThanhToan(thanhToan));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body("Lỗi  " + e.getMessage());
        }
    }
    @GetMapping("/nguoi-dung/{userId}")
    public ResponseEntity<?> getPaymentsByUser(@PathVariable int userId) {
        return ResponseEntity.ok(thanhToanService.getByUserId(userId));
    }

    @GetMapping("/ve/{ticketId}")
    public ResponseEntity<?> getPaymentsByTicket(@PathVariable int ticketId) {
        return ResponseEntity.ok(thanhToanService.getByTicketId(ticketId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateThanhToan(@PathVariable("id") int id, @Valid @RequestBody ThanhToanDTO thanhToanDTO){
        try {
            ThanhToan updateTT = thanhToanService.updateThanhToan(id, thanhToanDTO);
            return ResponseEntity.ok().body(ThanhToanResponse.fromThanhToan(updateTT));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteThanhToan(@PathVariable("id") int id){
        try {
            thanhToanService.deleteThanhToan(id);
            return ResponseEntity.ok().body("Đã xóa thành công");
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
