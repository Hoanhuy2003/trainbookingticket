package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.iservice.ILichTrinhService;
import com.project.tickettrainbooking.responses.LichTrinhResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lichtrinh")
public class LichTrinhController {
    private final ILichTrinhService lichTrinhService;

    public LichTrinhController(ILichTrinhService lichTrinhService) {
        this.lichTrinhService = lichTrinhService;
    }

    @GetMapping
    public ResponseEntity<List<LichTrinhResponse>> getAll() {
        return ResponseEntity.ok(lichTrinhService.getAll());
    }

    @PutMapping("/{maGaDi}/{maGaDen}")
    public ResponseEntity<LichTrinhResponse> update(@PathVariable Integer maGaDi,
                                                    @PathVariable Integer maGaDen,
                                                    @RequestParam String gioDi,
                                                    @RequestParam String gioDen) {
        return ResponseEntity.ok(lichTrinhService.updateSchedule(maGaDi, maGaDen, gioDi, gioDen));
    }
}
