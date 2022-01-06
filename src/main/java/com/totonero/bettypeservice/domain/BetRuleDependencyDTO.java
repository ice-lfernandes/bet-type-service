package com.totonero.bettypeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BetRuleDependencyDTO {
    private Long id;
    private BetDTO bet;
    private RuleDTO rule;
}
