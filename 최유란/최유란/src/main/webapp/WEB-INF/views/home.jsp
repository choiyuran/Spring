<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<details>
	<summary>SQL</summary>
	<fieldset  style="width: 700px">
		<pre>
	drop sequence review_seq;
	drop table review purge;
	drop sequence account_seq;
	drop table account purge;
	
	create sequence account_seq
	    start with 1
	    increment by 1
	    maxvalue 99999999
	    nocache
	    nocycle;
	
	create table account(
	    idx                 number          default account_seq.nextval primary key,
	    userid              varchar2(100)   not null unique,
	    userpw              varchar2(300)   not null,
	    username            varchar2(100)   not null,
	    salt                varchar2(100)   not null
	);
	
	create sequence review_seq
	    start with 1
	    increment by 1
	    maxvalue 99999999
	    nocache
	    nocycle;
	    
	create table review(
	    idx             number          default review_seq.nextval primary key,
	    title           varchar2(100)   not null,
	    account_idx     number          not null,
	    content         varchar2(4000)  not null,
	    wdate           date            default sysdate,
	    fileName        varchar2(255)   not null,
	    
	    constraint review_account_fk
	    foreign key (account_idx)
	    references account(idx)
	);
	select * from review;
	select 
	    RE.idx,
	    RE.title,
	    RE.wdate,
	    RE.filename,
	    AC.userid as account_userid
	    from review RE
	    join account AC
	    on RE.account_idx = AC.idx
	    order by RE.idx desc
		</pre>
	</fieldset>
</details>

<details>
	<summary>ERD</summary>
	<img src="${cpath }/resources/2023_09_21_회원제 리뷰 사이트.jpg" width="300">
</details>

</body>
</html>