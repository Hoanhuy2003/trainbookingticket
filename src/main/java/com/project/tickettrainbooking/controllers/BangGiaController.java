package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.BangGiaDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IBangGiaService;
import com.project.tickettrainbooking.models.BangGia;
import com.project.tickettrainbooking.responses.BangGiaResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/banggia")
public class BangGiaController {
    private final IBangGiaService bangGiaService;

    public BangGiaController(IBangGiaService bangGiaService) {
        this.bangGiaService = bangGiaService;
    }

    @PostMapping("")
    public ResponseEntity<?> createBangGia(@Valid @RequestBody BangGiaDTO bangGiaDTO){
        try {
            BangGia newBangGia = bangGiaService.createBangGia(bangGiaDTO);
            return ResponseEntity.ok().body(BangGiaResponse.fromBangGia(newBangGia));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getBangGiaById(@PathVariable("id") int id){
        try {
            BangGia bangGia = bangGiaService.getBangGiaById(id);
            return ResponseEntity.ok().body(BangGiaResponse.fromBangGia(bangGia));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("")
    public ResponseEntity<List<BangGiaResponse>> getAllBangGia(){
        List<BangGia> bangGias = bangGiaService.getAllBangGia();
        List<BangGiaResponse> responses = bangGias.stream()
                .map(BangGiaResponse::fromBangGia)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBangGia(@PathVariable("id") int id , @Valid @RequestBody BangGiaDTO bangGiaDTO){
        try {
            BangGia bangGia = bangGiaService.updateBangGia(id,bangGiaDTO);
            return ResponseEntity.ok().body(BangGiaResponse.fromBangGia(bangGia));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaBangGia(@PathVariable("id") int id){
        try {
            bangGiaService.deleteBangGia(id);
            return ResponseEntity.ok().body("Xóa thành công bảng giá có id:"+id);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
