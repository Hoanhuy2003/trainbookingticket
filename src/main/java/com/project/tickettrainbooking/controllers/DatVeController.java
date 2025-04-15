package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.DatVeDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IDatVeService;
import com.project.tickettrainbooking.models.DatVe;
import com.project.tickettrainbooking.responses.DatVeResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/datve")
public class DatVeController {
    private final IDatVeService datVeService;


    public DatVeController(IDatVeService datVeService) {
        this.datVeService = datVeService;
    }

    @PostMapping("")
    public ResponseEntity<?> createDatVe(@Valid @RequestBody DatVeDTO datVeDTO){
        try {
            DatVe newDatVe = datVeService.createDatVe(datVeDTO);
            return ResponseEntity.ok().body(DatVeResponse.fromDatVe(newDatVe));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getDatVeById (@PathVariable("id") int id){
        try {
            DatVe datVe = datVeService.getDatVebyId(id);
            return ResponseEntity.ok().body(DatVeResponse.fromDatVe(datVe));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("")
    public ResponseEntity<List<DatVeResponse>> getAllDatVe(){
        List<DatVe> datVes = datVeService.getAll();
        List<DatVeResponse> responses = datVes.stream()
                .map(DatVeResponse::fromDatVe)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDatVe(@PathVariable("id") int id, @Valid @RequestBody DatVeDTO datVeDTO){
        try {
            DatVe datVe = datVeService.updateDatVe(id,datVeDTO);
            return ResponseEntity.ok().body(DatVeResponse.fromDatVe(datVe));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDatVe(@PathVariable("id") int id){
        try {
            datVeService.deleteDatVe(id);
            return ResponseEntity.ok().body("Huy dat ve");
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
