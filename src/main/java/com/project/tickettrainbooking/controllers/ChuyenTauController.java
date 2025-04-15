package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.ChuyenTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IChuyenTauService;
import com.project.tickettrainbooking.models.ChuyenTau;
import com.project.tickettrainbooking.responses.ChuyenTauResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/chuyentau")
public class ChuyenTauController {
    private final IChuyenTauService chuyenTauService;

    public ChuyenTauController(IChuyenTauService chuyenTauService) {
        this.chuyenTauService = chuyenTauService;
    }

    @PostMapping("")
    public ResponseEntity<?> createChuyenTau(@Valid @RequestBody ChuyenTauDTO chuyenTauDTO){
        try {
            ChuyenTau newChuyenTau = chuyenTauService.createChuyenTau(chuyenTauDTO);
            return ResponseEntity.ok().body(ChuyenTauResponse.fromChuyenTau(newChuyenTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getChuyenTauById(@PathVariable("id") int id){
        try {
            ChuyenTau chuyenTau = chuyenTauService.getChuyenTauById(id);
            return ResponseEntity.ok().body(ChuyenTauResponse.fromChuyenTau(chuyenTau));
        } catch (DataNotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ChuyenTauResponse>> getAllChuyenTau(){
        List<ChuyenTau> chuyenTaus = chuyenTauService.getAllChuyenTau();
        List<ChuyenTauResponse> responses = chuyenTaus.stream()
                .map(ChuyenTauResponse::fromChuyenTau)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateChuyenTau(@PathVariable("id") int id , @Valid @RequestBody ChuyenTauDTO chuyenTauDTO){
        try {
            ChuyenTau chuyenTau = chuyenTauService.updateChuyenTau(id,chuyenTauDTO);
            return ResponseEntity.ok().body(ChuyenTauResponse.fromChuyenTau(chuyenTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaChuyenTau(@PathVariable("id") int id){
        try {
            chuyenTauService.deleteChuyenTau(id);
            return ResponseEntity.ok().body("Xóa thành công chuyến tàu có id:"+id);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
