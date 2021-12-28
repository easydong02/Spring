package com.koreait.mvc1223.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice {
	private int notice_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	private String filename;
	
	private MultipartFile myFile; //우리대신, 그 복잡했던 apache fileupload처리를 내부적으로 처리..
}
