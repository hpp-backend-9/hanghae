package com.hanghae.architecture.interfaces.api;

import com.hanghae.architecture.application.reservation.ReservationService;
import com.hanghae.architecture.interfaces.dto.ReservationResponse;
import com.hanghae.architecture.interfaces.dto.ReserveRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reservation")
@RestController
@RequiredArgsConstructor
public class ReservationApiController {

    private static final Logger log = LoggerFactory.getLogger(ReservationApiController.class);

    private final ReservationService reservationService;

    @GetMapping("{id}")
    public ResponseEntity<List<ReservationResponse>> history(
            @PathVariable(name = "id") long userId
    ) {
        return ResponseEntity.ok(reservationService.getReservations(userId));
    }

    @PostMapping("{id}")
    public ResponseEntity<Void> reserve(
            @PathVariable(name = "id") long userId,
            @RequestBody ReserveRequest reserveRequest
    ) {
        reservationService.reserve(userId, reserveRequest);
        return ResponseEntity.ok().build();
    }
}
