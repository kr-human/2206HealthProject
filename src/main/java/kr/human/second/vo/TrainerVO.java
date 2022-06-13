package kr.human.second.vo;

import java.util.Date;

import lombok.Data;

/*
	CREATE TABLE trainer(
   		t_id varchar2(30) PRIMARY KEY,
   		t_password varchar2(30) NOT NULL,
   		t_name varchar2(30) NOT NULL,
   		t_birth date NOT NULL,
   		t_addr varchar2(30) NOT NULL,
   		t_email varchar2(30) NOT NULL,
   		t_nicname varchar2(30) NOT NULL,
		lev number(2),
   		t_gender char(1) NOT null
	);
*/
@Data
public class TrainerVO {
	private String t_id;
	private String t_password;
	private String t_name;
	private String t_addr;
	private String t_email;
	private String t_nicname;
	private boolean t_gender;
	private Date t_birth;
	private int lev;
}
