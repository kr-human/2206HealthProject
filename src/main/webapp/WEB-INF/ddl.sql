<<<<<<< HEAD
CREATE SEQUENCE ptclass_idx_sqe;

CREATE TABLE ptclass(
   idx number PRIMARY key,
   pttime DATE,
   t_id varchar2(30) NOT NULL,
   CONSTRAINT fk_t_id_ptclass FOREIGN key(t_id) REFERENCES trainer(t_id),
   check char(1)
);

SELECT * FROM ptclass;
DROP TABLE PTCLASS;
=======
CREATE TABLE MEMBERS(
	id varchar2(30) PRIMARY KEY,
	password varchar2(30) NOT NULL,
	name varchar2(30) NOT NULL,
	postcode varchar2(10) NOT NULL,
	addr1 varchar2(100) NOT NULL,
	addr2 varchar2(100) NOT NULL,
	email varchar2(50) NOT NULL,
	gender char(1) CHECK(gender IN('M','F')),
	pt number(3),
	startday date,
	endday date,
	lev number(2),
	myTrainer varchar2(30) NOT NULL
);
DROP TABLE MEMBERS;
SELECT * FROM MEMBERS;

INSERT INTO MEMBERS VALUES 
('root','1234','최고관리자',' ',' ',' ','ithuman202204@gmail.com','M',0,'2022-05-30','2023-05-30',3,'sys');
INSERT INTO MEMBERS VALUES 
('user01','1234','한사람',' ',' ',' ','ithuman202204@gmail.com','F',0,'2022-05-30','2023-05-30',1,'root');
>>>>>>> hwan91





