package kr.human.second.vo;

import lombok.Data;

/*
 CREATE TABLE reservation(
   t_id varchar2(30) NOT NULL,
   CONSTRAINT fk_t_id_reservation FOREIGN key(t_id) REFERENCES trainer(t_id),
   pt_code varchar2(10) NOT NULL,
   CONSTRAINT fk_pt_code_reservation FOREIGN key(pt_code) REFERENCES ptclass(pt_code)
  ); 
 */
@Data
public class ReservationVO {
	private String t_id;
	private String pt_code;
}
