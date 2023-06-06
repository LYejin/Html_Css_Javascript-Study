package com.jquery.ajax.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDTO {
	private int seq;
	private String title;
	private String content;
	private String regdate;
	private int hit;
}
