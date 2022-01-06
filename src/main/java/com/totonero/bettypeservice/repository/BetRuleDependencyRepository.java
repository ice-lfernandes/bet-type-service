package com.totonero.bettypeservice.repository;

import java.util.List;

import com.totonero.bettypeservice.repository.entity.BetRuleDependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRuleDependencyRepository extends JpaRepository<BetRuleDependency, Long> {

    List<BetRuleDependency> findByBet_id(final Long betId);

}
