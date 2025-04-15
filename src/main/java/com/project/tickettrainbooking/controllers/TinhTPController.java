package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.TinhTPDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.ITinhTPService;
import com.project.tickettrainbooking.models.TinhTP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/TinhTP")

public class TinhTPController {
    private final ITinhTPService tinhTPService;

    public TinhTPController(ITinhTPService tinhTPService) {
        this.tinhTPService = tinhTPService;
    }
    @GetMapping("")
    public ResponseEntity<List<TinhTP>> getAllTinhTP(){
        List<TinhTP> tinhTPs = tinhTPService.getAllTinhTP();
        return ResponseEntity.ok(tinhTPs);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TinhTP> getTinhTPById(@PathVariable Integer id) throws DataNotFoundException {
        return ResponseEntity.ok(tinhTPService.getTinhTPById(id));
    }
    @PostMapping("")
    public ResponseEntity<TinhTP> createTinhTP(@RequestBody TinhTPDTO tinhTPDTO){
        return ResponseEntity.ok(tinhTPService.creteTinhTP(tinhTPDTO));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<TinhTP> updateTinhTP(@PathVariable Integer id, @RequestBody TinhTPDTO tinhTPDTO) throws DataNotFoundException {
        return ResponseEntity.ok(tinhTPService.updateTinhTP(id, tinhTPDTO));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteTinhTP(@PathVariable Integer id) throws DataNotFoundException {
        tinhTPService.deleteTinhTP(id);
        return ResponseEntity.noContent().build();
    }
}
