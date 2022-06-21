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
	u_postcode varchar2(10) NOT NULL,
	u_addr1 varchar2(100) NOT NULL,
	u_addr2 varchar2(100) NOT NULL,
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
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String postcode;
	private String addr1;
	private String addr2;
	private String email;
	private String gender;
	private int pt;
	private Date startDay;
	private Date endDay;
	private int lev;
	private String myTrainer;
	
}
