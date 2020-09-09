package com.winter.baseballproject.domain.stardium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StardiumRepository extends JpaRepository<Stardium, Integer> {
	
	@Modifying
	@Query(value = "DELETE FROM stardium WHERE id = ?1", nativeQuery = true)
	int Stardium삭제하기(int id);
}
