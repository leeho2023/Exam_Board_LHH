package org.study.sample.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	
	private int b_no;
	private String b_title;
	private String b_content;
	private String b_writer;
	private Timestamp b_regDate;
	private Timestamp b_modifyRegDate;
	
	
}
