package kr.human.second.vo;

import java.util.Date;

import lombok.Data;

/*
 	CREATE TABLE ptclass(
   		pt_code varchar2(10) PRIMARY key,
   		pttime DATE NOT null,
   		t_id varchar2(30) NOT NULL,
   		CONSTRAINT fk_t_id_ptclass FOREIGN key(t_id) REFERENCES trainer(t_id)
	);
*/
@Data
public class PTClassVO {
	private String pt_code;
	private Date ptTime;
	private String t_id;
	private boolean r_check;
}
