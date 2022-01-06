package com.totonero.bettypeservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.totonero.bettypeservice.domain.BetDTO;
import com.totonero.bettypeservice.domain.BetRuleDependencyDTO;
import com.totonero.bettypeservice.repository.BetRuleDependencyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
public class BetRuleDependencyService {

    private static final Logger log = LoggerFactory.getLogger(BetRuleDependencyService.class);

    private final BetRuleDependencyRepository repository;
    private final ModelMapper modelMapper;

    public List<BetRuleDependencyDTO> findByBetId(final Long betId) {
        return repository.findByBet_id(betId)
                .stream().map(bet -> modelMapper.map(bet, BetRuleDependencyDTO.class))
                .collect(Collectors.toList());
    }

}
