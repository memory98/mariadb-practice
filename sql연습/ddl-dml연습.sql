drop table member;
create table member(
 no int not null auto_increment,
 email varchar(100) not null,
 password varchar(64) not null,
 name varchar(100) not null,
 department varchar(100),
 
 primary key(no)
);

desc member;

alter table member add column juminbungo char(13) not null;
desc member;


alter table member drop juminbungo;
desc member;

alter table member add column juminbungo char(13) not null after email;
desc member;

alter table member change column department dept varchar(200) not null;
desc member;


alter table member add self_intro text;
desc member;

alter table member drop juminbungo;
desc member;

-- insert 
insert
	into member
values(null,'aq12@naver.com',password('1234'),'정은성','개발팀',null);
select * from member;

insert
	into member(no,email,name,dept,password)
values(null,'aq13@naver.com','정은성','개발팀',password('1234'));
select * from member;

-- update
update member
	set email='aq13@naver.com',password=password('5678')
 where no = 2;
select * from member;

-- delete
delete
	from member
 where no = 2;
select * from member;

-- transaction 1 : true
select @@autocommit;
set autocommit=0;

insert
	into member
values(null,'aq17@naver.com',password('1234'),'정은성','개발팀',null);
select * from member;

commit;

