package com.koreait.mvc1223.domain;

import lombok.Data;

@Data
public class Board {
	private int board_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	private int team;
	private int step; 
	private int depth;
}
