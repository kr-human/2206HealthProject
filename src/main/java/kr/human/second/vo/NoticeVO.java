package kr.human.second.vo;

import java.util.Date;



import lombok.Data;

/*
 * CREATE SEQUENCE notice_idx_sqe;
CREATE TABLE notice(
	idx NUMBER PRIMARY KEY,
	subject varchar2(100) NOT NULL,
	content varchar2(3000) NOT NULL,
	regDate timestamp DEFAULT SYSDATE,
	clickCount number(20) DEFAULT 0
);
*/
@Data
public class NoticeVO {
	private int idx;
	private String subject;
	private String content;
	private Date regDate;
	private int clickCount;
	
	private int mode; // 수정, 삭제 , 작성 구분하기 위해 사용함
}
