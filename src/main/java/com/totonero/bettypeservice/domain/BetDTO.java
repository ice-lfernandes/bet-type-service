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
public class BetDTO {
    private Long id;
    private Long parentId;
    private Long evictId;
    private String name;
    private String type;
    private String nameSimple;
    private int valueGreen;
    private int score;
    private double unit;
    private int minimumScore;
    private double minimumUnit;
    private Integer minimumAlertMinute;
    private Integer maximumAlertMinute;
    private Integer maximumEntryMinute;
    private Integer minimumGreenMinute;
    private Integer maximumGreenMinute;
    private Integer quantityToGreen;
    private Double minimumOdd;
    private Boolean isEqual;
    private Boolean isFirstHalf;
    private Boolean isAbleToClose;
    private Integer maximumCheckCloseMinute;
    private Integer maximumCheckCloseNeutralMinute;
    private Boolean isPush;
    private Boolean isLosingRequired;
    private Integer maximumAdvantageInResult;
    private String nameBalance;
    private Integer negativeScoreEvictIsPush;
    private Boolean isPlus;
    private Boolean isEnabled;
    private Double automationLine;
}
