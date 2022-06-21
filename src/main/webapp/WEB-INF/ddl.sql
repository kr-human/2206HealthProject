CREATE SEQUENCE pt_code_sqe;
CREATE SEQUENCE notice_idx_sqe;


DROP table notice;
SELECT * FROM notice;
CREATE TABLE notice(
	idx NUMBER PRIMARY KEY,
	subject varchar2(100) NOT NULL,
	content varchar2(3000) NOT NULL,
	regDate timestamp DEFAULT SYSDATE,
	clickCount number(20) DEFAULT 0
);
INSERT INTO notice
VALUES(1,'안녕', '안녕하세요', SYSDATE, 0);



