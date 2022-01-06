package com.totonero.bettypeservice.web.jmx;

import static com.totonero.bettypeservice.web.jmx.constants.JmxMessages.MESSAGE_CHANGED_SCORE_ERROR;
import static com.totonero.bettypeservice.web.jmx.constants.JmxMessages.MESSAGE_CHANGED_SCORE_OK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.totonero.bettypeservice.domain.BetDTO;
import com.totonero.bettypeservice.service.BetService;
import lombok.RequiredArgsConstructor;
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
@ManagedResource(description = "Operações relacionadas ao Score de Bets")
public class ScoreJMX {

    private static final Logger log = LoggerFactory.getLogger(ScoreJMX.class);

    private final BetService betService;

    @ManagedOperation(description = "Altera score de uma Bet")
    @ManagedOperationParameters({
            @ManagedOperationParameter(description = "Nome da bet", name = "betName"),
            @ManagedOperationParameter(description = "Boolean indicando se o periodo é primeiro tempo", name = "isFirstHalf"),
            @ManagedOperationParameter(description = "Score da aposta", name = "score"),
            @ManagedOperationParameter(description = "Indica se o score mínimo que deve ser alterado", name = "isMinimumScore"),
    })
    public String changeScore(final String betName, final Boolean isFirstHalf, final Integer score, final boolean isMinimumScore) {
        try {
            betService.changeScore(betName, isFirstHalf, score, isMinimumScore);
            log.info("stage=score-changed-success, betName={}, isFirstHalf={}, newScore={}, isMinimumScore={}", betName, isFirstHalf,
                    score, isMinimumScore);
            return MESSAGE_CHANGED_SCORE_OK;
        } catch (RuntimeException exception) {
            log.error("stage=score-changed-error, betName={}, isFirstHalf={}, newScore={}, isMinimumScore={}", betName, isFirstHalf,
                    score, isMinimumScore, exception);
            return MESSAGE_CHANGED_SCORE_ERROR;
        }
    }

    @ManagedOperation(description = "Altera score de todas as Bets somando ou diminuindo o score informado")
    @ManagedOperationParameter(description = "Soma ou diminui o score informado com os valores de cada aposta", name = "score")
    public String changeAllScore(final Integer score) {
        try {
            betService.changeAllScore(score);
            log.info("stage=score-changed-all-bets-success, newScore={}", score);
            return MESSAGE_CHANGED_SCORE_OK;
        } catch (RuntimeException exception) {
            log.error("stage=score-changed-all-bets-error, newScore={}", score, exception);
            return MESSAGE_CHANGED_SCORE_ERROR;
        }
    }

    @ManagedOperation(description = "Retorna score de todas as Bet")
    public Map<BetDTO, List<Integer>> getAllScore() {
        final Map<BetDTO, List<Integer>> mapResponse = new HashMap<>();
        betService.findAll().forEach(betDTO -> mapResponse.put(betDTO, Lists.newArrayList(betDTO.getMinimumScore(), betDTO.getScore())));
        return mapResponse;
    }

}
