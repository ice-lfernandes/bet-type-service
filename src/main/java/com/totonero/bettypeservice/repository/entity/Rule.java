package com.totonero.bettypeservice.repository.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rule")
public class Rule {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idt_rule")
    private Long id;

    @Column(name = "idt_parent")
    private Long parentId;

    @ManyToOne
    @JoinColumn(name = "idt_bet")
    private Bet bet;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Integer value;

    @Column(name = "score")
    private Integer score;

    @Column(name = "is_mandatory")
    private Boolean isMandatory;

    @Column(name = "is_mandatory_after_red_card")
    private Boolean isMandatoryAfterRedCard;

    @Column(name = "is_underdog_team")
    private Boolean isUnderdogTeam;

    @Column(name = "is_equal")
    private Boolean isEqual;
}
