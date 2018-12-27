--create table user (id integer not null, birth_date timestamp, name varchar(255), primary key (id))

insert into user values(1001, sysdate(), 'Jack');
insert into user values(1002, sysdate(), 'Jill');
insert into user values(1003, sysdate(), 'Juno');

insert into post values(11001, 'My first post', 1001);
insert into post values(11002, 'My second post', 1002);
insert into post values(11003, 'My first post', 1003);