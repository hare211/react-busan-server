package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.BusanFoodEntity;

@Repository
public interface BusanFoodRepository extends JpaRepository<BusanFoodEntity, Integer>{
	@Query(value = "SELECT * FROM busan_food WHERE score > 4.5 limit 2", nativeQuery = true)
	List<BusanFoodEntity> findBusanFoodHighScore();
	
}
