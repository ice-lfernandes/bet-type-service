package com.totonero.bettypeservice.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RuleResponseDTO {
    private Long id;
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
