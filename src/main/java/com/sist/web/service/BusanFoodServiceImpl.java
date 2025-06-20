package com.sist.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sist.web.dao.BusanFoodRepository;
import com.sist.web.entity.BusanFoodEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanFoodServiceImpl implements BusanFoodService {
	
	private final BusanFoodRepository bDao;
	
	@Override
	public List<BusanFoodEntity> getBusanFoodHighScore() {
		
		return bDao.findBusanFoodHighScore();
	}
	
	@Override
	public Page<BusanFoodEntity> getBusanFoodPagingList(Pageable pageable) {
		
		return bDao.findAllWithPaging(pageable);
	}
	
	@Override
	public BusanFoodEntity getBusanFoodDetail(int fno) {
		
		return bDao.findBusanFoodDetail(fno);
	}
}
