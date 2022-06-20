CREATE SEQUENCE pt_code_sqe;
CREATE SEQUENCE notice_idx_sqe;

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
	gender char(1) CHECK(gender IN('M','F')),
	t_id varchar2(30) NOT NULL,
	CONSTRAINT fk_t_id FOREIGN key(t_id) REFERENCES trainer(t_id)
);
DROP TABLE users;
SELECT * FROM users;

INSERT INTO users(u_id, u_password, u_nicname, u_name, u_birth, u_addr, u_email, gender, t_id) 
VALUES ('oss71401', 'dhtjd4861', 'dominic1', 'SeongSeok1', TO_date('19940905', 'YYYY/MM/DD'), '경기도평택1', 'oss7140@naver.com', 1, 'oss7140');

INSERT INTO USERS(u_id, u_password, u_nicname, u_name, u_birth, u_addr, u_email, gender, t_id)
	VALUES
	('user01','1234','서울사람','나그네',TO_date('19940905', 'YYYY/MM/DD'), '경기도평택1', 'oss7140@naver.com', 1, 'oss7140');
INSERT INTO USERS 
	VALUES
	('user03','1234','굳은','나무','1999-08-15',' ','korea@hanmail.com',null,null,null,null,0,'oss7140');
INSERT INTO USERS 
	VALUES
	('user04','1234','시원','바람','2001-06-05',' ',' ',' ','korea@hanmail.com',null,null,null,null,'F','pt04');

CREATE TABLE trainer(
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
);

DROP TABLE TRAINER;
SELECT * FROM TRAINER ;
INSERT INTO trainer VALUES
	('pt01','1234','선생1','1988-06-29',' ',' ',' ','korea@hanmail.com','근육몬','M',NULL);
INSERT INTO trainer VALUES
	('pt02','1234','선생2','1988-06-29',' ',' ',' ','korea@hanmail.com','근육몬','F',null);
INSERT INTO trainer VALUES
	('pt03','1234','선생3','1988-06-29',' ',' ',' ','korea@hanmail.com','근육몬','M',null);
INSERT INTO trainer VALUES
	('pt04','1234','선생4','1988-06-29',' ',' ',' ','korea@hanmail.com','근육몬','F',null);


DROP TABLE PTCLASS;
CREATE TABLE ptclass(
   pt_code varchar2(10) PRIMARY key,
   title varchar2(50),
   start1 date,
   end1 date,
   pttime DATE,
   t_id varchar2(30) NOT NULL,
   CONSTRAINT fk_t_id_ptclass FOREIGN key(t_id) REFERENCES trainer(t_id),
   r_check char(1)
);
SELECT * FROM ptclass;
INSERT INTO ptclass VALUES ('2022061718', '18:00~19:00',to_date('2022/06/20 18:00','YYYY/MM/DD HH24:MI'), to_date('2022/06/20 19:00','YYYY/MM/DD HH24:MI'), to_date('2022/06/20 19:00','YYYY/MM/DD HH24:MI'),'oss7140', 0);
DROP TABLE ptclass;

CREATE TABLE reservation(
   t_id varchar2(30) NOT NULL,
   CONSTRAINT fk_t_id_reservation FOREIGN key(t_id) REFERENCES trainer(t_id),
   pt_code varchar2(10) NOT NULL,
   CONSTRAINT fk_pt_code_reservation FOREIGN key(pt_code) REFERENCES ptclass(pt_code),
   u_id varchar2(30) NOT NULL,
   CONSTRAINT fk_u_id_reservation FOREIGN key(u_id) REFERENCES users(u_id)
);
SELECT * FROM reservation;
DROP TABLE reservation;

DROP TABLE ADMIN;
SELECT * FROM ADMIN ;
CREATE TABLE admin(
   a_id varchar2(30) PRIMARY key,
   a_password varchar2(30) NOT NULL,
   lev number(2) NOT null
);
INSERT INTO admin VALUES 
('root','1234','4');
INSERT INTO admin VALUES 
('system','1234','4');
INSERT INTO admin VALUES 
('master','1234','4');


DROP table notice;
SELECT * FROM notice;
CREATE TABLE notice(
	idx NUMBER PRIMARY KEY,
	subject varchar2(100) NOT NULL,
	content varchar2(3000) NOT NULL,
	regDate timestamp DEFAULT SYSDATE
);

INSERT INTO notice VALUES 
(notice_idx_sqe.nextval,'나나나나나나나나나','2022-06-07','운동하는날',5,'root');
INSERT INTO notice VALUES 
(notice_idx_sqe.nextval,'가가가가가가가가가','2022-06-07','운동안하는날',5,'root');
INSERT INTO notice VALUES 
(notice_idx_sqe.nextval,'타타타타타','2022-06-07','운동',5,'root');
INSERT INTO notice VALUES 
(notice_idx_sqe.nextval,'냠냠냠냠','2022-06-07','식단',5,'root');

CREATE TABLE upfile(
	idx NUMBER PRIMARY KEY,
	ref NUMBER NOT NULL, -- 원본글번호
	ofile varchar2(100) NOT NULL, -- 원본 파일명
	sfile varchar2(100) NOT NULL  -- 저장 파일명
);
SELECT * FROM tab;

SELECT U_NAME ,U_BIRTH ,U_ADDR ,U_EMAIL,GENDER  FROM USERS ;
SELECT * FROM ADMIN ;
SELECT * FROM notice;
SELECT T_NAME ,T_BIRTH ,T_ADDR ,T_GENDER  FROM TRAINER ;
		
insert into notice 
			(idx,content,regDate,subject,clickcount)
		VALUES
			(fileBoard_idx_seq.nextval,#{content},SYSDATE),#{subject},#{clickcount}





