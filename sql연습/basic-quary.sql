select version(), current_date(), now() from dual;

-- 사칙 연산가능 --
select 1+2+3+4 from dual;

select version(), current_date(), now() from dual;

 -- 대소문자 구분 x --
 seLect VERSION(), current_date, NOW() from dual;
 
 select sin(pi() /4),1+2*3-4/5 from dual;

 show tables;
 
 -- table 생성 :DML 
create table pet (
	name varchar(100),
	owner varchar(20) ,
	species varchar(20),
	gender char(1),
	birth date,
	death date
);

-- schema 확인 
desc pet;
show tables;
-- table 삭제 drop
 -- insert " DML(C)
 insert into pet values('보리','정은성','dog','m','2020-11-11',null);
 
 select * from pet;