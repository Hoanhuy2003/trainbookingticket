package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.VeTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IVeTauService;
import com.project.tickettrainbooking.models.VeTau;
import com.project.tickettrainbooking.responses.VeTauResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/vetau")
public class VeTauController {
    private final IVeTauService veTauService;

    public VeTauController(IVeTauService veTauService) {
        this.veTauService = veTauService;
    }

    @PostMapping("")
    public ResponseEntity<?> createVeTau(@Valid @RequestBody VeTauDTO veTauDTO){
        try {
            VeTau newVeTau = veTauService.createVeTau(veTauDTO);
            return ResponseEntity.ok().body(VeTauResponse.fromVeTau(newVeTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVeTauById(@PathVariable("id") int id){
        try {
            VeTau veTau = veTauService.getVeTauById(id);
            return ResponseEntity.ok().body(VeTauResponse.fromVeTau(veTau));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<VeTauResponse>> getAll(){
        List<VeTau> veTaus = veTauService.getAllVeTau();
        List<VeTauResponse> responses = veTaus.stream()
                .map(VeTauResponse::fromVeTau)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVeTau(@PathVariable("id") int id, @Valid @RequestBody VeTauDTO veTauDTO){
        try {
            VeTau updateVe = veTauService.updateVeTau(id, veTauDTO);
            return ResponseEntity.ok().body(VeTauResponse.fromVeTau(updateVe));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVeTau(@PathVariable("id") int id){
        try {
            veTauService.deleteVeTau(id);
            return ResponseEntity.ok().body("Xoa Thanh cong");
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
