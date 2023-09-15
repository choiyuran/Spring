desc upload1;
drop table upload1 purge;

create table upload1(
    idx                 number          GENERATED AS IDENTITY,
    title               varchar2(100)   not null,
    originalFileName    varchar2(500)   not null,
    storedFileName      varchar2(500)   not null
);
select * from upload1;