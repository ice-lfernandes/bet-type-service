package com.totonero.bettypeservice.repository.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bet_rule_dependency")
public class BetRuleDependency {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idt_bet_rule_dependency")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idt_bet")
    private Bet bet;

    @ManyToOne
    @JoinColumn(name = "idt_rule")
    private Rule rule;
}
