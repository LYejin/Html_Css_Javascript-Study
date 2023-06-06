package com.jquery.ajax.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CommentDTO {
	private int board_id;
	private int seq;
	private String comment;
}
