drop table upload1 purge;

create table upload1(
    idx         number          GENERATED AS IDENTITY primary key,
    title       varchar2(100)   not null,
    fileName    varchar2(500)   not null
);
select * from upload1;
