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

-- �ܷ�Ű�� �����Ҷ� �����ϴ� ���̺��� primary key �Ǵ� uniqueŰ�� ������ �� �ִµ�
-- uniqueŰ�� �����ϰ� �Ǹ� join�� ����� �ʿ���� �ٷ� ������ �� �ִ�
-- join�� ����ϰ� �ϱ� ���ؼ� ���⼭�� idx�� �����ؼ� �ܷ�Ű�� �����Ѵ�
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
select * from board4;
select * from member2;

-- �۹�ȣ, ����, �ۼ����� username, �ۼ���¥, ��ȸ���� �ҷ�����
select 
    Bo.idx, Bo.title,
    Me.username,
    Bo.fileName,
    Bo.wdate, Bo.viewCount
    from board4 Bo
        join member2 Me
        on Bo.member2_idx = Me.idx
        -- where idx = #{idx} join�ؼ� ���� ��ȸ�Ҷ�      
        order by idx desc;
    