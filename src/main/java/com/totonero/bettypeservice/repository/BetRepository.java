package com.totonero.bettypeservice.repository;

import java.util.List;
import java.util.Optional;

import com.totonero.bettypeservice.repository.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BetRepository extends JpaRepository<Bet, Long> {

    @Query("SELECT b FROM Bet b " +
            "WHERE b.type = 'ALERT'")
    List<Bet> findAlertBet();

    Optional<Bet> findByNameAndIsFirstHalf(final String name, final Boolean isFirstHalf);

    @Query("SELECT b FROM Bet b " +
            "WHERE b.id = ?1 " +
            "AND b.type = 'ALERT'")
    Optional<Bet> findAlertBetById(final Long id);

    List<Bet> findByParentId(final Long parentId);

    @Query("SELECT b FROM Bet b " +
            "WHERE b.maximumAlertMinute >= ?1 " +
            "AND b.minimumAlertMinute <= ?1 " +
            "AND b.type = 'ALERT' " +
            "AND b.isEnabled IS TRUE")
    List<Bet> findByAlertMinute(final Integer minute);
}
