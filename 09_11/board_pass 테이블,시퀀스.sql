drop table board_pass purge;
drop sequence board_pass_seq;

create sequence board_pass_seq
	start with 1
	maxvalue 99999999999999999
	increment by 1
	nocache
	nocycle;

create table board_pass(
	idx		number		default board_pass_seq.nextval primary key,
	title		varchar2(100)	not null,
	writer		varchar2(50)	not null,
	password	varchar2(50)	not null,
	content		clob		    not null,
    viewCount   number          default 0,
    wdate       date            default sysdate

);
select * from board_pass;

select * from board_pass where title like '%6%';

 

