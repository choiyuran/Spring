set define off;

drop sequence artist_seq;
drop sequence album_seq;
drop sequence music_seq;
drop sequence member_seq;
drop sequence post_seq;
drop sequence reply_seq;
drop sequence playlist_seq;
drop sequence likecount_seq;

drop table artist cascade constraints purge;
drop table album cascade constraints purge;
drop table music cascade constraints purge;
drop table member cascade constraints purge;
drop table post cascade constraints purge;
drop table reply cascade constraints purge;
drop table playlist cascade constraints purge;
drop table likecount cascade constraints purge;

create sequence artist_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;
    
create sequence album_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

create sequence music_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

create sequence member_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;
create sequence post_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;
create sequence reply_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;
create sequence playlist_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;
    
create sequence likecount_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

create table artist (
    id          number          default artist_seq.nextval primary key,
    name        varchar2(200)   not null,
    company     varchar2(200)   ,
    country     varchar2(100)   ,
    member      varchar2(200)   not null,
    debut       date            ,
    type        varchar2(100)   not null,
    profileImg  varchar2(500)   
);

create table album (
    id          number          default album_seq.nextval primary key,
    artist_id   number          not null,
    name        varchar2(200)   not null,
    type        varchar2(100)   not null,
    rDate       date            not null,
    playTime    number          not null,
    coverImg    varchar2(500),
    
    constraint album_artist_fk
    foreign key (artist_id)
    references artist(id)
);

create table music (
    id          number          default music_seq.nextval primary key,
    artist_id   number          not null,
    album_id    number          not null,
    name        varchar2(200)   not null,
    genre       varchar2(100)   not null,
    playtime    number          not null,
    lyrics      clob            ,
    playCount   number          default 0,
    isTitle	    number		    default 0,	-- Ÿ��Ʋ ������ �ƴ��� �Ǻ�, 0�� �ƴϸ� Ÿ��Ʋ ��
    
    constraint music_artist_fk
    foreign key (artist_id)
    references artist(id),
    
    constraint music_album_fk
    foreign key (album_id)
    references album(id)
);

create table member (
    id          number          default member_seq.nextval primary key,
    userid      varchar2(100)   unique not null,
    userpw      varchar2(500)   not null,
    username    varchar2(100)   not null,
    email       varchar2(100)   not null,
    gender      varchar2(100)   check (gender in ('����', '����')),
    birth       date            not null
);

create table post (
    id          number          default post_seq.nextval primary key,
    member_id   number          not null,
    album_id    number          ,
    music_id    number          ,
    title       varchar2(200)   not null,
    content     clob            not null,
    wDate       date            default sysdate,
    viewCount   number          default 0,
    category	varchar2(100)	not null,
    titleImg    varchar2(500)   not null,
    subImg1     varchar2(500)   ,
    subImg2     varchar2(500)   ,
    subImg3     varchar2(500)   ,
    
    constraint post_member_fk
    foreign key (member_id)
    references member(id),
    
    constraint post_album_fk
    foreign key (album_id)
    references album(id),
    
    constraint post_music_fk
    foreign key (music_id)
    references music(id)
);

create table reply (
    id          number          default reply_seq.nextval primary key,
    member_id   number          not null,
    post_id     number          not null,
    content     clob            not null,
    
    constraint reply_member_fk
    foreign key (member_id)
    references member(id),
    
    constraint reply_post_fk
    foreign key (post_id)
    references post(id)
);

create table playlist (
    id          number          default playlist_seq.nextval primary key,
    member_id   number          not null,
    music_id    number          not null,
    title       varchar2(100)   not null,
    wDate       date            default sysdate,
    
    constraint playlist_member_fk
    foreign key (member_id)
    references member(id),
    
    constraint playlist_music_fk
    foreign key (music_id)
    references music(id)
);

create table likecount (
    id          number          default likecount_seq.nextval primary key,
    member_id   number          not null,
    type        varchar2(100)   check(type in ('ARTIST', 'ALBUM', 'MUSIC', 'POST', 'REPLY')),
    ref         number          not null,
    
    constraint likecount_member_fk
    foreign key(member_id)
    references member(id),
    
    constraint likecount_unique
    unique(member_id, type, ref)
);
----------------------------------------------------------------------------------------------------------------------------------
insert into member (userid, userpw, username, email, gender, birth)
    values ('admin', '1', '������', 'admin@itbank.com', '����', '1970/01/01');
----------------------------------------------------------------------------------------------------------------------------------

--1
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('AKMU(�ǹ�)', 'YG Family', '���ѹα�', '������, �̼���', '2013/04/07', '��� (ȥ��)', '�ǹ�.jpg');
--2    
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('��ź�ҳ��', 'BigHit', '���ѹα�', 'RM, SUGA, ��, j-hope, ����, V, ����', '2013/06/13', '�׷� (����)', '��ź�ҳ��.jpg');
--3
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('������', '�̽�ƽ���丮', '���ѹα�', '-', '1990/07/15', '�ַ� (����)', '������.jpeg');
--4
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('aespa', 'SM Entertainment', '���ѹα�', 'ī����, ����, ����, �״�', '2020/11/17', '�׷� (����)', 'aespa.jpg');
--5
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('Ariana Grande(�Ƹ��Ƴ� �׶���)', 'Republic Record', '�̱�', '-', '2008/01/01', '�ַ� (����)', '�Ƹ��Ƴ��׶���.jpg');
--6
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('AJR','-','�̱�','�ƴ� ��, ���̾� ��, �� ��','2005/01/01','�׷� (����)','AJR.jpg');
--7
insert into artist (name, company, country, member, debut, type, profileImg)
	values ('BoyWithUke', 'Republic Records', '���ѹα�',' BoyWithUke', '2021/01/22', '�ַ�', 'BoyWithUke.jpg');
--8
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('BIGBANG(���)', 'YG Family', '���ѹα�', 'G-DRAGON, �¾�, �뼺, T.O.P', '2006/08/19', '�׷� (����)', '���.jpg');
--9
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('Post Malone(����Ʈ ����)', 'Republic Records', '�̱�', '-', '2015/08/14', '�ַ� (����)', 'PostMalone.jpg');
--10
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('10cm', '��ġ�� ����(����&10cm)', '���ѹα�', '-', '2010/04/22', '�ַ� (����)', '10cm.jpg');
--11
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('������(IU)', '�̴� �������θ�Ʈ', '���ѹα�', '-', '2008/09/18', '�ַ� (����)', '1067e01d3fda4508a867c4c861f5d4a1.jpg');
--12
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('IVE (���̺�)', '��Ÿ�� �������θ�Ʈ', '���ѹα�', '�����, ������, ����, ����, ����, �̼�', '2021/12/01', '�׷� (����)', '26bce679f5364bfdb3f49d65ac449437.jpg');
--13
insert into artist (name, company, country, member, debut, type, profileImg) 
    values ('��ȿ��', '�����Ϸ�', '���ѹα�', '-', '1999/11/04', '�ַ� (����)', '5670998e2bb6405897074e3310986817.jpg');

----------------------------------------------------------------------------------------------------------------------------------
--1
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (1, '�ᶱ����', '�̱�', '2013/05/23', 178, '�ǹ�_�ᶱ����.jpg');
--2    
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (1, 'PLAY', '����', '2014/04/07', 2297, '�ǹ�_PLAY.jpg');
--3
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (2, 'Skool Luv Affair', 'EP(�̴�)', '2014/02/12', 2124, '��ź�ҳ��_SkoolLuvAffair.jpg');
--4
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (2, 'Butter / Permission to Dance', '�̱�', '2021/07/09', 700, '��ź�ҳ��_Butter_PermissionToDance.jpg');
--5
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (3, '�ຸ 2013 ������', '����', '2013/12/20', 6032, '������_�ຸ2013.jpg');
--6
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (6, 'OK ORCHESTRA','����','2021/03/26',2748, 'AJR_OK_ORCHESTRA.jpg');
--7
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (6, 'Record Player','�̱�','2021/08/31',149, 'AJR_RecordPlayer.jpg');
--8
insert into album  (artist_id, name, type, rdate, playtime, coverImg) 
	values(7, 'Toxic', '�̱�', '2021/10/29', 168, 'BoyWithUke_Toxic.jpg');
--9
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
 	values (7, 'Serotonin Dreams', '����', '2022/05/06', 1828, 'BoyWithUke_SerotoninDreams.jpg'); 
--10    
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (8, 'MADE', '����', '2016/12/13', 2448, '���_MADE.jpg');
--11
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (9, 'AUSTIN', '����', '2023/07/28', 3101, 'PostMalone_AUSTIN.jpg');
--12
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (10, '5.3', '�̱�', '2022/07/03', 402, '10cm_5.3.jpg');
--13
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (10, '4.0', '����', '2017/09/01', 1717, '10cm_4.0.jpg');
--14
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (11, 'Lost And Found', 'EP(�̴�)', '2008/09/23', 1304, '172170ec6aed41789a36448b2c24d1c4.jpg');
--15
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (11, 'Growing Up', '����', '2009/04/23', 3381, '54193617d9eb4e1e99fdc06047af4e5b.jpg');
--16
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (11, '������', 'EP(�̴�)', '2021/12/29', 1070, '22d7d23f520f453b9846292c44597399.jpg');
--17
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (12, 'I WANT', '�̱�', '2023/07/13', 180, 'a05e7c136f834147a72076574f0a898d.jpg');
--18
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (12, 'After LIKE', '�̱�', '2022/08/22', 370, '321d3ccac7af4f1f979fe71790da63e0.jpg');
--19
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (4, 'Savage - The 1st Mini Album', 'EP(�̴�)', '2021/10/05', 1213, 'ef1d8d85204c4df98bd2b5c46974f2c9.jpg');
--20
insert into album (artist_id, name, type, rdate, playtime, coverImg) 
    values (13, 'I am A Dreamer', '����', '2016/10/03', 3482, 'af08e66d041143d8bedffe16a54747db.jpg');
----------------------------------------------------------------------------------------------------------------------------------




----------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------
commit;
-- desc music;
-- select * from artist order by id desc;
-- select * from album order by id desc;
-- select * from music order by id desc;

select 
    AL.id as �ٹ�_id, 
    AL.name as �ٹ�, 
    AR.name as ��Ƽ��Ʈ,
    MU.id as ����_id,
    MU.name as ���
        from album AL
        join artist AR
            on AL.artist_id = AR.id
        join music MU
            on MU.album_id = AL.id
    order by MU.id;
desc music;

-- as�ڿ� �����ϴ� ������ dto�� ������ �ʵ��� ���ƾ� �Ѵ�
select 
    AR.name as artist_name,
    AL.name as album_name,
    MU.*
        from music MU
			join artist AR
                on MU.artist_id = AR.id
            join album AL
                on MU.album_id = AL.id
            order by MU.id;
        

