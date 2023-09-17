select tname from tab;
drop sequence board3_seq;
drop table board3 purge;
drop sequence member3_seq;
drop table member3 purge;


create sequence member3_seq
    start with 1
    increment by 1
    maxvalue 999999999999999
    nocycle
    nocache;
    
create table member3(
    idx                     number             default member3_seq.nextval primary key,
    userid                  varchar2(50)       not null unique,
    userpw                  varchar2(500)      not null,
    username                varchar2(50)       not null,
    salt                    varchar2(50)       not null,
    email                   varchar2(100)      not null unique,
    originalFileName        varchar2(500),      
    storedFileName          varchar2(500)
);

create sequence board3_seq
   start with 1
    increment by 1
    maxvalue 999999999999999
    nocycle
    nocache;
    
select * from member3;
create table board3(
    idx                     number              default board3_seq.nextval primary key,
    title                   varchar2(100)       not null,
    writer                  varchar2(50)        not null,
    password                varchar2(50)        not null,
    content                 clob                not null,
    viewCount               number              default 0,
    wdate                   date                default sysdate,
    originalFileName        varchar2(500),
    storedFileName          varchar2(500),

    constraint board3_fk
    foreign key(writer)
    references member3(userid)
);