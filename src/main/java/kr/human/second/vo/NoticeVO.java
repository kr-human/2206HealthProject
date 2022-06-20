package kr.human.second.vo;

import java.util.Date;
import java.util.List;


import lombok.Data;

/*
CREATE TABLE notice(
	idx NUMBER PRIMARY KEY,
	subject varchar2(100) NOT NULL,
	content varchar2(3000) NOT NULL,
	regDate timestamp DEFAULT SYSDATE
);
*/
@Data
public class NoticeVO {
	private int idx;
	private String subject;
	private String content;
	private Date regDate;
	
	private int mode;
	private List<UpFileVO> fileList;

}
