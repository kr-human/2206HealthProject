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
DROP TABLE trainer;

CREATE TABLE ptclass(
   pt_code varchar2(10) PRIMARY key,
   pttime DATE NOT null,
   t_id varchar2(30) NOT NULL,
   CONSTRAINT fk_t_id_ptclass FOREIGN key(t_id) REFERENCES trainer(t_id)
);
SELECT * FROM ptclass;

CREATE TABLE reservation(
   t_id varchar2(30) NOT NULL,
   CONSTRAINT fk_t_id_reservation FOREIGN key(t_id) REFERENCES trainer(t_id),
   pt_code varchar2(10) NOT NULL,
   CONSTRAINT fk_pt_code_reservation FOREIGN key(pt_code) REFERENCES ptclass(pt_code)
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







