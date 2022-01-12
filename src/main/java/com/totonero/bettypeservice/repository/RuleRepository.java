package com.totonero.bettypeservice.repository;

import java.util.List;

import com.totonero.bettypeservice.repository.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RuleRepository extends JpaRepository<Rule, Long> {

    @Query("SELECT r FROM Rule r " +
            "JOIN r.bet b " +
            "WHERE b.id = ?1 " +
            "AND r.type = 'ALERT'")
    List<Rule> findAlertRulesByBetId(final Long betId);

    @Query("SELECT r FROM Rule r " +
            "JOIN r.bet b " +
            "WHERE b.id = ?1")
    List<Rule> findRulesByBetId(final Long betId);

    List<Rule> findByBet_nameAndBet_IsFirstHalf(final String betName, final Boolean isFirstHalf);

    @Query("SELECT r FROM Rule r " +
            "WHERE r.type = 'ANALYSIS'")
    List<Rule> findAnalysisRules();

    List<Rule> findByBet_idAndParentId(final Long betId, final Long parentId);
}
