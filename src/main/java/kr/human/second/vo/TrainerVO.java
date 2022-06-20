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
	
	t_id varchar2(30) PRIMARY KEY,
   t_password varchar2(30) NOT NULL,
   t_name varchar2(30) NOT NULL,
   t_birth date NOT NULL,
   t_postcode varchar2(10) NOT NULL,
   t_addr1 varchar2(100) NOT NULL,
   t_addr2 varchar2(100) NOT NULL,
   t_email varchar2(30) NOT NULL,
   t_nicname varchar2(30) NOT NULL,
   gender char(1) CHECK(gender IN('M','F')),
   lev number(2)  
	
*/
@Data
public class TrainerVO {
	private String t_id;
	private String t_password;
	private String t_name;
	private Date t_birth;
	private String t_postcode;
	private String t_addr1;
	private String t_addr2;
	private String t_email;
	private String t_nicname;
	private boolean t_gender;
	private int lev;
}
