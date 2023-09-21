<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<details>
		<summary>SQL</summary>
		<fieldset>
			<pre>
	drop sequence board4_seq;
	drop table board4 purge;
	drop sequence member2_seq;
	drop table member2 purge;
	
	
	create sequence member2_seq
	    start with 1
	    increment by 1
	    maxvalue 9999999999999
	    nocache
	    nocycle;
	    
	    
	create sequence board4_seq
	    start with 1
	    increment by 1
	    maxvalue 9999999999999
	    nocache
	    nocycle;
	    
	
	create table member2(
	    idx         number          default member2_seq.nextval primary key,
	    userid      varchar2(100)   not null unique,
	    userpw      varchar2(300)   not null,
	    salt        varchar2(100)   not null,
	    username    varchar2(100)   not null,
	    email       varchar2(100)   not null
	);
	
	-- 외래키를 지정할때 참조하는 테이블의 primary key 또는 unique키로 지정할 수 있는데
	-- unique키를 참조하게 되면 join을 사용할 필요없이 바로 가져올 수 있다
	-- join을 사용하게 하기 위해서 여기서는 idx를 참조해서 외래키를 생성한다
	create table board4(
	    idx          number              default board4_seq.nextval primary key,
	    title        varchar2(100)       not null,
	    member2_idx  number              not null,
	    content      varchar2(4000)      not null,
	    fileName     varchar2(255),
	    wdate        date                default sysdate,
	    viewCount    number              default 0,
	    
	    constraint board4_member2_fk
	    foreign key (member2_idx)
	    references member2(idx)
	    
	);
			</pre>
		</fieldset>
	</details>
	
	<details>
		<summary>ERD</summary>
		<img width="700" src="${cpath }/resources/20230920_member2_board4_ERD.jpg">
	</details>
	

</div>

</body>
</html>