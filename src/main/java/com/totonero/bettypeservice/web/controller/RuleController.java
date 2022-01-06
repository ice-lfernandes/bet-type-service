package com.totonero.bettypeservice.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.stream.Collectors;

import com.totonero.bettypeservice.service.RuleService;
import com.totonero.bettypeservice.web.response.RuleResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(RuleController.RULE_ENDPOINT)
public class RuleController {

    public static final String RULE_ENDPOINT = "/rule";

    private final RuleService service;
    private final ModelMapper modelMapper;

    @GetMapping(path = "/bet/{betId}", produces = APPLICATION_JSON_VALUE)
    public List<RuleResponseDTO> findRulesByBetId(@PathVariable("betId") final Long betId) {
        return service.findRulesByBetId(betId)
                .stream()
                .map(ruleDTO -> modelMapper.map(ruleDTO, RuleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/bet/{betId}/alert", produces = APPLICATION_JSON_VALUE)
    public List<RuleResponseDTO> findAlertRulesByBetId(@PathVariable("betId") final Long betId) {
        return service.findAlertRulesByBetId(betId)
                .stream()
                .map(ruleDTO -> modelMapper.map(ruleDTO, RuleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/analyzable", produces = APPLICATION_JSON_VALUE)
    public List<RuleResponseDTO> findAnalyzableRules() {
        return service.findAnalyzableRules()
                .stream()
                .map(ruleDTO -> modelMapper.map(ruleDTO, RuleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/parent/{parentId}", produces = APPLICATION_JSON_VALUE)
    public List<RuleResponseDTO> findByBetAndParentId(@PathVariable("parentId") final Long parentId,
                                                      @RequestParam("betId") final Long betId) {
        return service.findByBetAndParentId(betId, parentId)
                .stream()
                .map(ruleDTO -> modelMapper.map(ruleDTO, RuleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/bet/{betId}/dependency", produces = APPLICATION_JSON_VALUE)
    public List<RuleResponseDTO> findByBetAndParentId(@PathVariable("betId") final Long betId) {
        return service.findRulesDependencyByBetId(betId)
                .stream()
                .map(ruleDTO -> modelMapper.map(ruleDTO, RuleResponseDTO.class))
                .collect(Collectors.toList());
    }
}
