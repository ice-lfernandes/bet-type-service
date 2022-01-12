package com.totonero.bettypeservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.totonero.bettypeservice.domain.BetRuleDependencyDTO;
import com.totonero.bettypeservice.domain.RuleDTO;
import com.totonero.bettypeservice.exceptions.ResourceNotFoundException;
import com.totonero.bettypeservice.repository.RuleRepository;
import com.totonero.bettypeservice.repository.entity.Rule;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RuleService {

    private static final Logger log = LoggerFactory.getLogger(RuleService.class);

    private final RuleRepository repository;
    private final BetRuleDependencyService betRuleDependencyService;
    private final ModelMapper modelMapper;

    public RuleDTO findById(final Long id) {
        return repository.findById(id)
                .map(bet -> modelMapper.map(bet, RuleDTO.class))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public List<RuleDTO> findAlertRulesByBetId(final Long betId) {
        return repository.findAlertRulesByBetId(betId)
                .stream()
                .map(rule -> modelMapper.map(rule, RuleDTO.class))
                .collect(Collectors.toList());
    }

    public List<RuleDTO> findRulesByBetId(final Long betId) {
        return repository.findRulesByBetId(betId)
                .stream()
                .map(rule -> modelMapper.map(rule, RuleDTO.class))
                .collect(Collectors.toList());
    }

    public List<RuleDTO> findByBetNameAndPeriod(final String betName, final Boolean isFirstHalf) {
        return repository.findByBet_nameAndBet_IsFirstHalf(betName, isFirstHalf)
                .stream()
                .map(rule -> modelMapper.map(rule, RuleDTO.class))
                .collect(Collectors.toList());
    }

    public List<RuleDTO> findAnalysisRules() {
        return repository.findAnalysisRules()
                .stream()
                .map(rule -> modelMapper.map(rule, RuleDTO.class))
                .collect(Collectors.toList());
    }

    public List<RuleDTO> findRulesDependencyByBetId(final Long betId) {
        return betRuleDependencyService.findByBetId(betId).stream()
                .map(BetRuleDependencyDTO::getRule)
                .collect(Collectors.toList());
    }

    public List<RuleDTO> findByBetAndParentId(final Long betId, final Long parentId) {
        return repository.findByBet_idAndParentId(betId, parentId)
                .stream()
                .map(rule -> modelMapper.map(rule, RuleDTO.class))
                .collect(Collectors.toList());
    }

    public void updateScore(final Long id, final Integer newScore) {
        final RuleDTO ruleDTO = findById(id);
        ruleDTO.setScore(newScore);
        final Rule rule = repository.save(modelMapper.map(ruleDTO, Rule.class));
        log.info("stage=update-rule-score, rule={}, newScore={}, betType={}, isFirstHalf={}", rule.getName(), rule.getScore(),
                rule.getBet().getName(), rule.getBet().getIsFirstHalf());
    }
}
