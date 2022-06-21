package kr.human.second.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PTClassVO {
	private int idx;
	private Date ptTime;
	private String t_id;
	private boolean check;
}
