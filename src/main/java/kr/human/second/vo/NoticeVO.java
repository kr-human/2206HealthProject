package kr.human.second.vo;

import java.util.Date;

import lombok.Data;

/*
CREATE TABLE notice(
   idx number(10) PRIMARY KEY,
   content varchar2(4000),
   regDate DATE,
   subject varchar2(500),
   clickcount number(4),
   a_id varchar2(10) NOT NULL,
   CONSTRAINT fk_a_id_notice FOREIGN key(a_id) REFERENCES admin(a_id)
);
*/
@Data
public class NoticeVO {
	private int idx;
	private String content;
	private Date regDate;
	private String subject;
	private int clickCount;
	private String a_id;
}
