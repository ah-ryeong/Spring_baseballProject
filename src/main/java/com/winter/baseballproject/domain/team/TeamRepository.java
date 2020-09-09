package com.winter.baseballproject.domain.team;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Integer>{

	@Modifying
	@Query(value = "DELETE FROM team WHERE id = ?1", nativeQuery = true)
	int Team삭제하기(int id);
	
	@Modifying
	@Query(value = "SELECT * FROM team WHERE teamName = ?1", nativeQuery = true)
	List<Team> 입력된팀찾기(String teamName);
}
