package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.ToaTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IToaTauService;
import com.project.tickettrainbooking.models.ToaTau;
import com.project.tickettrainbooking.responses.ToaTauResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/toatau")
public class ToaTauController {
    private final IToaTauService tauService;

    public ToaTauController(IToaTauService tauService) {
        this.tauService = tauService;
    }

    @PostMapping("")
    public ResponseEntity<?> createToaTau(@Valid @RequestBody ToaTauDTO toaTauDTO){
        try {
            ToaTau newToaTau = tauService.createToaTau(toaTauDTO);
            return ResponseEntity.ok().body(ToaTauResponse.fromToaTau(newToaTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getToaTauById(@PathVariable("id") int id){
        try {
            ToaTau toaTau = tauService.getToaTauById(id);
            return ResponseEntity.ok().body(ToaTauResponse.fromToaTau(toaTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ToaTauResponse>> getAllToaTau(){
        List<ToaTau> toaTaus = tauService.getAllToaTau();
        List<ToaTauResponse> responses = toaTaus.stream()
                .map(ToaTauResponse::fromToaTau)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateToaTau(@PathVariable("id") int id, @Valid @RequestBody ToaTauDTO toaTauDTO){
        try {
            ToaTau updateToaTau = tauService.updateToaTau(id,toaTauDTO);
            return ResponseEntity.ok().body(ToaTauResponse.fromToaTau(updateToaTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToaTau(@PathVariable("id") int id){
        try {
            tauService.deleteToaTau(id);
            return ResponseEntity.ok().body("Đã xóa toa tàu có id: "+id);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
