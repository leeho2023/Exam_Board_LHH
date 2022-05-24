package org.study.sample.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_address;
	private Timestamp m_regDate;
	
	@Override
	public String toString() {
		return "MemberDTO [m_no=" + m_no + ", m_id=" + m_id + ", m_address=" + m_address + ", m_regDate=" + m_regDate
				+ "]";
	}

	
}
