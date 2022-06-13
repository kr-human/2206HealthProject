package kr.human.second.vo;

import java.util.Date;

import lombok.Data;

/*
CREATE TABLE users(
	u_id varchar2(30) PRIMARY KEY,
	u_password varchar2(30) NOT NULL,
	u_nicname varchar2(30) NOT NULL,
	u_name varchar2(30) NOT NULL,
	u_birth date NOT NULL,
	u_addr varchar2(100) NOT NULL,
	u_email varchar2(50) NOT NULL,
	lev number(2),
	pt number(3),
	startday date,
	endday date,
	gender char(1) NOT NULL,
	t_id varchar2(30) NOT NULL,
	CONSTRAINT fk_t_id FOREIGN key(t_id) REFERENCES trainer(t_id)
);
 */
@Data
public class UsersVO {
	private String u_id;
	private String u_password;
	private String u_nicname;
	private String u_name;
	private Date u_birth;
	private String u_addr;
	private String u_email;
	private int lev;
	private int pt;
	private Date startDay;
	private Date endDay;
	private boolean gender;
	private String t_id;
	
}
