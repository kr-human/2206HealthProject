CREATE SEQUENCE pt_code_sqe;
CREATE SEQUENCE notice_idx_sqe;

DROP TABLE users;
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
SELECT * FROM users;
INSERT INTO users(u_id, u_password, u_nicname, u_name, u_birth, u_addr, u_email, gender, t_id) 
VALUES ('oss71401', 'dhtjd4861', 'dominic1', 'SeongSeok1', TO_date('19940905', 'YYYY/MM/DD'), '경기도평택1', 'oss7140@naver.com', 1, 'oss7140');
DROP TABLE users;

CREATE TABLE trainer(
   t_id varchar2(30) PRIMARY KEY,
   t_password varchar2(30) NOT NULL,
   t_name varchar2(30) NOT NULL,
   t_birth date NOT NULL,
   t_addr varchar2(30) NOT NULL,
   t_email varchar2(30) NOT NULL,
   t_nicname varchar2(30) NOT NULL,
   lev number(2),
   t_gender char(1) NOT null
);
SELECT * FROM trainer;
INSERT INTO trainer VALUES ('oss7140', 'dhtjd486', 'SeongSeok', TO_date('19940905', 'YYYY/MM/DD'), '경기도평택', 'oss7140@naver.com', 'dominic', 3, 1);
DROP TABLE trainer;

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

CREATE TABLE admin(
   a_id varchar2(30) PRIMARY key,
   a_password varchar2(30) NOT NULL,
   lev number(2) NOT null
);
SELECT * FROM admin;
DROP TABLE admin;

CREATE TABLE notice(
   idx number(10) PRIMARY KEY,
   content varchar2(4000),
   regDate DATE,
   subject varchar2(500),
   clickcount number(4),
   a_id varchar2(10) NOT NULL,
   CONSTRAINT fk_a_id_notice FOREIGN key(a_id) REFERENCES admin(a_id)
);
SELECT * FROM notice;
DROP TABLE notice;

SELECT * FROM tab;





