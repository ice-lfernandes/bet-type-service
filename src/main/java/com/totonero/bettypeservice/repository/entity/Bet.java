package com.totonero.bettypeservice.repository.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "bet")
public class Bet {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idt_bet")
    private Long id;

    @Column(name = "idt_parent")
    private Long parentId;

    @Column(name = "idt_evict")
    private Long evictId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "name_simple")
    private String nameSimple;

    @Column(name = "value_green")
    private Integer valueGreen;

    @Column(name = "score")
    private int score;

    @Column(name = "unit")
    private double unit;

    @Column(name = "minimum_score")
    private int minimumScore;

    @Column(name = "minimum_unity")
    private double minimumUnit;

    @Column(name = "minimum_alert_minute")
    private Integer minimumAlertMinute;

    @Column(name = "maximum_alert_minute")
    private Integer maximumAlertMinute;

    @Column(name = "maximum_entry_minute")
    private Integer maximumEntryMinute;

    @Column(name = "minimum_green_minute")
    private Integer minimumGreenMinute;

    @Column(name = "maximum_green_minute")
    private Integer maximumGreenMinute;

    @Column(name = "quantity_to_green")
    private Integer quantityToGreen;

    @Column(name = "minimum_odd")
    private Double minimumOdd;

    @OneToMany(mappedBy = "bet")
    private List<Rule> rules;

    @Column(name = "is_equal")
    private Boolean isEqual;

    @Column(name = "is_first_half")
    private Boolean isFirstHalf;

    @Column(name = "is_able_to_close")
    private Boolean isAbleToClose;

    @Column(name = "maximum_check_close_minute")
    private Integer maximumCheckCloseMinute;

    @Column(name = "maximum_check_close_neutral_minute")
    private Integer maximumCheckCloseNeutralMinute;

    @Column(name = "is_push")
    private Boolean isPush;

    @Column(name = "is_losing_required")
    private Boolean isLosingRequired;

    @Column(name = "maximum_advantage_in_result")
    private Integer maximumAdvantageInResult;

    @Column(name = "name_balance")
    private String nameBalance;
}
