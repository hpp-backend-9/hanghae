package io.hhplus.tdd.point.controller;

import io.hhplus.tdd.point.dto.PointHistoryResponse;
import io.hhplus.tdd.point.dto.UserPointResponse;
import io.hhplus.tdd.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {

    private static final Logger log = LoggerFactory.getLogger(PointController.class);

    private final PointService pointService;

    /**
     * TODO - 특정 유저의 포인트를 조회하는 기능을 작성해주세요.
     */
    @GetMapping("{id}")
    public ResponseEntity<UserPointResponse> point(
            @PathVariable(name = "id") long id
    ) {
        return ResponseEntity.ok(pointService.getPoint(id));
    }

    /**
     * TODO - 특정 유저의 포인트 충전/이용 내역을 조회하는 기능을 작성해주세요.
     */
    @GetMapping("{id}/histories")
    public ResponseEntity<List<PointHistoryResponse>> history(
            @PathVariable(name = "id") long id
    ) {
        return ResponseEntity.ok(pointService.getHistories(id));
    }

    /**
     * TODO - 특정 유저의 포인트를 충전하는 기능을 작성해주세요.
     */
    @PatchMapping("{id}/charge")
    public ResponseEntity<UserPointResponse> charge(
            @PathVariable(name = "id") long id,
            @RequestBody long amount
    ) {
        return ResponseEntity.ok(pointService.charge(id, amount));
    }

    /**
     * TODO - 특정 유저의 포인트를 사용하는 기능을 작성해주세요.
     */
    @PatchMapping("{id}/use")
    public ResponseEntity<UserPointResponse> use(
            @PathVariable(name = "id") long id,
            @RequestBody long amount
    ) {
        return ResponseEntity.ok(pointService.use(id, amount));
    }
}
