package com.winter.baseballproject.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Integer>{

	@Modifying
	@Query(value = "DELETE FROM team WHERE id = ?1", nativeQuery = true)
	int Team삭제하기(int id);
}
