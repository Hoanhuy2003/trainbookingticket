package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.GheDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IGheService;
import com.project.tickettrainbooking.models.Ghe;
import com.project.tickettrainbooking.responses.GheResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/ghe")
public class GheController {
    private final IGheService gheService;

    public GheController(IGheService gheService) {
        this.gheService = gheService;
    }

    @PostMapping("")
    public ResponseEntity<?> createGhe(@Valid @RequestBody GheDTO gheDTO){
        try {
            Ghe newGhe = gheService.createGhe(gheDTO);
            return ResponseEntity.ok().body(GheResponse.fromGhe(newGhe));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGheById(@PathVariable("id") int id){
        try {
            Ghe ghe = gheService.getGheById(id);
            return ResponseEntity.ok().body(GheResponse.fromGhe(ghe));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<GheResponse>> getAllGhe(){
        List<Ghe> ghes = gheService.getAllGhe();
        List<GheResponse> responses = ghes.stream()
                .map(GheResponse::fromGhe)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGhe(@Valid @RequestBody GheDTO gheDTO, @PathVariable("id") int id){
        try {
            Ghe updateGhe = gheService.updateGhe(id,gheDTO);
            return ResponseEntity.ok().body(GheResponse.fromGhe(updateGhe));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGhe(@PathVariable("id") int id){
        try {
            gheService.deleteGhe(id);
            return ResponseEntity.ok().body("Đã xóa thành công ghế có id"+id);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
