package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "busan_food")
@Getter @Setter
public class BusanFoodEntity {
	@Id
	private int fno;
	private String name;
	private String type;
	private String phone;
	private String address;
	private String theme;
	private String poster;
	private String images;
	private String time;
	private String content;
	private String price;
	private double score;
	private int hit;
}
