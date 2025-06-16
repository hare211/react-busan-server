package com.sist.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sist.web.entity.BusanFoodEntity;

public interface BusanFoodService {
	List<BusanFoodEntity> getBusanFoodHighScore();
	Page<BusanFoodEntity> getBusanFoodPagingList(Pageable pageable);
	BusanFoodEntity getBusanFoodDetail(int fno);
}
