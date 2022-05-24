package org.study.sample.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
	
	private int r_no;
	private int r_boardNum;
	private String r_writer;
	private String r_content;
	private Timestamp r_regDate;
	
	
}
