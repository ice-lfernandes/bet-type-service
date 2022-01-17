package com.totonero.bettypeservice.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.totonero.bettypeservice.domain.BetDTO;
import com.totonero.bettypeservice.exceptions.ResourceNotFoundException;
import com.totonero.bettypeservice.repository.BetRepository;
import com.totonero.bettypeservice.repository.entity.Bet;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
public class BetService {

    private static final Logger log = LoggerFactory.getLogger(BetService.class);

    private final BetRepository repository;
    private final ModelMapper modelMapper;

    public BetDTO findById(final Long id) {
        return repository.findById(id)
                .map(bet -> modelMapper.map(bet, BetDTO.class))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public List<BetDTO> findAll() {
        return repository.findAll()
                .stream().map(bet -> modelMapper.map(bet, BetDTO.class))
                .collect(Collectors.toList());
    }

    public BetDTO findAlertBetById(final Long id) {
        return repository.findAlertBetById(id)
                .map(bet -> modelMapper.map(bet, BetDTO.class))
                .orElseThrow(ResourceNotFoundException::new);
    }


    public BetDTO findByNameAndPeriod(final String name, final Boolean isFirstHalf) {
        return repository.findByNameAndIsFirstHalf(name, isFirstHalf)
                .map(bet -> modelMapper.map(bet, BetDTO.class))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void changeScore(final String name, final Boolean isFirstHalf, final Integer newScore, final boolean isMinimumScore) {
        final BetDTO betDTO = findByNameAndPeriod(name, isFirstHalf);
        if (isMinimumScore) {
            betDTO.setMinimumScore(newScore);
        } else {
            betDTO.setScore(newScore);
        }
        final Bet bet = repository.save(modelMapper.map(betDTO, Bet.class));
        log.info("stage=bet-score-updated, bet-score={}, bet-minimum-score={}", bet.getScore(), bet.getMinimumScore());
    }

    public void changeAllScore(final Integer score) {
        findAll().forEach(betDTO -> {
            betDTO.setScore(betDTO.getScore() + score);
            betDTO.setMinimumScore(betDTO.getMinimumScore() + score);
            final Bet betPersisted = repository.save(modelMapper.map(betDTO, Bet.class));
            log.info("stage=bet-score-updated, bet-score={}, bet-minimum-score={}", betPersisted.getScore(),
                    betPersisted.getMinimumScore());
        });
    }

    public List<BetDTO> findByParentId(final Long parentId) {
        return repository.findByParentId(parentId)
                .stream().map(bet -> modelMapper.map(bet, BetDTO.class))
                .collect(Collectors.toList());
    }

    public BetDTO findAlertBetByMinute(final Integer minute, final Integer quantityCorner) {
        final List<BetDTO> list = repository.findByAlertMinute(minute).stream()
                .map(bet -> modelMapper.map(bet, BetDTO.class))
                .collect(Collectors.toList());
        if (list.size() > 1) {
            if(list.stream().allMatch(betDTO -> betDTO.getValueGreen() > 0)) {
                return list.stream()
                        .min(Comparator.comparingInt(i -> Math.abs(quantityCorner - (i.getValueGreen() - 3))))
                        .get();
            }
            return list.stream()
                    .filter(betDTO -> betDTO.getValueGreen() > 0 &&
                    betDTO.getValueGreen() - 2 >= quantityCorner)
                    .findFirst()
                    .orElseGet(() -> list.stream().filter(dto -> dto.getValueGreen() == 0).findFirst().get());
        }
        return list.stream().findFirst().orElse(null);
    }
}
