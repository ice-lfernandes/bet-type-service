package com.totonero.bettypeservice.web.jmx;

import static com.totonero.bettypeservice.web.jmx.constants.JmxMessages.MESSAGE_CHANGED_SCORE_ERROR;
import static com.totonero.bettypeservice.web.jmx.constants.JmxMessages.MESSAGE_CHANGED_SCORE_OK;

import java.util.List;
import java.util.stream.Collectors;

import com.totonero.bettypeservice.exceptions.ResourceNotFoundException;
import com.totonero.bettypeservice.service.RuleService;
import com.totonero.bettypeservice.web.response.RuleResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
@ManagedResource(description = "Operações relacionadas as Rules de Bets")
public class BetRulesJMX {

    private static final Logger log = LoggerFactory.getLogger(BetRulesJMX.class);

    private final RuleService ruleService;
    private final ModelMapper modelMapper;

    @ManagedOperation(description = "Retorna as regras de pontuação de score de uma Bet")
    @ManagedOperationParameters({
            @ManagedOperationParameter(description = "Nome da bet", name = "betName"),
            @ManagedOperationParameter(description = "Boolean indicando se o periodo é primeiro tempo", name = "isFirstHalf")
    })
    public List<RuleResponseDTO> getRulesByBet(final String betName, final Boolean isFirstHalf) {
        return ruleService.findByBetNameAndPeriod(betName, isFirstHalf)
                .stream()
                .map(ruleDTO -> modelMapper.map(ruleDTO, RuleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @ManagedOperation(description = "Altera o score de uma regra de para uma Bet")
    @ManagedOperationParameters({
            @ManagedOperationParameter(description = "Id da rule", name = "id"),
            @ManagedOperationParameter(description = "score da rule", name = "score")
    })
    public String changeScoreRule(final Long id, final int score) {
        try {
            ruleService.updateScore(id, score);
            return MESSAGE_CHANGED_SCORE_OK;
        } catch (ResourceNotFoundException exception) {
            log.info("stage=not-found-change-score-rule, ruleId={}", id);
            return MESSAGE_CHANGED_SCORE_ERROR;
        }
    }
}
