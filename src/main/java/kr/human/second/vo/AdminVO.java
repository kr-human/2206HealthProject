package kr.human.second.vo;

import lombok.Data;

/*
CREATE TABLE admin(
   a_id varchar2(30) PRIMARY key,
   a_password varchar2(30) NOT NULL,
   lev number(2) NOT null
);
*/
@Data
public class AdminVO {
	private String a_id;
	private String a_password;
	private int lev;
}
