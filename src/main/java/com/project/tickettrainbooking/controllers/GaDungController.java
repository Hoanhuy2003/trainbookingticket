package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.GaDungDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IGaDungService;
import com.project.tickettrainbooking.models.GaDung;
import com.project.tickettrainbooking.pkfk.GaDungId;
import com.project.tickettrainbooking.responses.GaDungResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/gadung")
public class GaDungController {
    private final IGaDungService gaDungService;

    public GaDungController(IGaDungService gaDungService) {
        this.gaDungService = gaDungService;
    }
    @GetMapping("/{maGaDi}/{maGaDen}/{maTau}")
    public ResponseEntity<List<GaDungResponse>> getByChuyenTau(@PathVariable Integer maGaDi,
                                                               @PathVariable Integer maGaDen,
                                                               @PathVariable Integer maTau) {
        return ResponseEntity.ok(gaDungService.getByChuyenTau(maGaDi, maGaDen, maTau));
    }



    @PostMapping
    public ResponseEntity<?> create(@RequestBody GaDungDTO dto)  {

        try {
            GaDung gaDung = gaDungService.create(dto);
            return ResponseEntity.ok().body(GaDungResponse.fromGaDung(gaDung));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


        //return ResponseEntity.ok(gaDungService.create(dto));
    }

    @PutMapping
    public ResponseEntity<GaDungResponse> update(@RequestBody GaDungDTO dto) {
        GaDungId id = new GaDungId(dto.getMaGaDi(), dto.getMaGaDen(), dto.getMaTau(), dto.getMaGaDung());
        return ResponseEntity.ok(gaDungService.update(id, dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody GaDungId id) {
        gaDungService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
