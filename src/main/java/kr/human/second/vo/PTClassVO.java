package kr.human.second.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PTClassVO {
	private int idx;
	private String ptTime;
	private String id;
	private String r_check;
	
	private int count;
	
	//insert or delete type
	private String type;
}
