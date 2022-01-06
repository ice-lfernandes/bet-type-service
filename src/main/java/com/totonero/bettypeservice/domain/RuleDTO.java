package com.totonero.bettypeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RuleDTO {
    private Long id;
    private BetDTO bet;
    private String type;
    private String name;
    private Integer value;
    private int score;
    private Long ruleParentId;
    private Boolean isMandatory;
    private Boolean isMandatoryAfterRedCard;
    private Boolean isUnderdogTeam;
    private Boolean isEqual;
}
