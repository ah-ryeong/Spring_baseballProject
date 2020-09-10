package com.winter.baseballproject.domain.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	@Modifying
	@Query(value = "DELETE FROM player WHERE id = ?1", nativeQuery = true)
	int Player삭제하기(int id);
}
