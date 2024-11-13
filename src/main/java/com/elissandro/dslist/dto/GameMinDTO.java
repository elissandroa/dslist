package com.elissandro.dslist.dto;

import com.elissandro.dslist.entities.Game;
import com.elissandro.dslist.projections.GameMinProjection;

public class GameMinDTO {
	private Long Id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO() {
	}

	
	public GameMinDTO(Game entity) {
		Id = entity.getId(); 
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection projection) {
		Id = projection.getId(); 
		title = projection.getTitle();
		year = projection.getGameYear();
		imgUrl =projection.getImgUrl();
		shortDescription = projection.getShortDescription();
	}


	public Long getId() {
		return Id;
	}


	public String getTitle() {
		return title;
	}


	public Integer getYear() {
		return year;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public String getShortDescription() {
		return shortDescription;
	}

}
