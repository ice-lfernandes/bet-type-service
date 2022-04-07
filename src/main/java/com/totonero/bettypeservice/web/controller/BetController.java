package com.totonero.bettypeservice.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Objects;

import com.totonero.bettypeservice.domain.BetDTO;
import com.totonero.bettypeservice.service.BetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(BetController.BET_ENDPOINT)
public class BetController {

    public static final String BET_ENDPOINT = "/bet";

    private final BetService service;

    @GetMapping(path = "/alert", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BetDTO> findAlertBet(@RequestParam("minute") final Integer minute,
                                               @RequestParam("quantityCorner") final Integer quantityCorner) {
        final BetDTO betDTO = service.findAlertBetByMinute(minute, quantityCorner);
        if (Objects.isNull(betDTO)) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(betDTO);
    }

    @GetMapping(path = "/dash", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BetDTO> findDashBet(@RequestParam("minute") final Integer minute,
                                              @RequestParam("quantityCorner") final Integer quantityCorner) {
        final BetDTO betDTO = service.findDashBetByMinute(minute, quantityCorner);
        if (Objects.isNull(betDTO)) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(betDTO);
    }

    @GetMapping(path = "/{id}/alert", produces = APPLICATION_JSON_VALUE)
    public BetDTO findAlertBetById(@PathVariable("id") final Long id) {
        return service.findAlertBetById(id);
    }

    @GetMapping(path = "/parent/{parentId}", produces = APPLICATION_JSON_VALUE)
    public List<BetDTO> findByParentId(@PathVariable("parentId") final Long parentId) {
        return service.findByParentId(parentId);
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public BetDTO findById(@PathVariable("id") final Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<BetDTO> findAll() {
        return service.findAll();
    }
}

