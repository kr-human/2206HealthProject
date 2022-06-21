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





