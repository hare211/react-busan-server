package com.sist.web.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.BusanFoodEntity;

@Repository
public interface BusanFoodRepository extends JpaRepository<BusanFoodEntity, Integer>{
	@Query(value = "SELECT * FROM busan_food WHERE score > 4.5 limit 2", nativeQuery = true)
	List<BusanFoodEntity> findBusanFoodHighScore();
	
	@Query(value = "SELECT * FROM busan_food", countQuery = "SELECT count(*) FROM busan_food", nativeQuery = true)
	Page<BusanFoodEntity> findAllWithPaging(Pageable pageable);
	
	@Query(value = "SELECT * FROM busan_food WHERE fno = :fno", nativeQuery = true)
	BusanFoodEntity findBusanFoodDetail(@Param("fno") int fno);
	
}
