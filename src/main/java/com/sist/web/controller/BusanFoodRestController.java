package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.BusanFoodEntity;
import com.sist.web.service.BusanFoodService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/busan-food")
public class BusanFoodRestController {
	
	private final BusanFoodService bService;
	
	@GetMapping("/high-score")
	public ResponseEntity<List<BusanFoodEntity>> getBusanFoodHighScore() {
		List<BusanFoodEntity> list = new ArrayList<>();
		try {
			list = bService.getBusanFoodHighScore();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		return ResponseEntity.ok(list);
	}
}
