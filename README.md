- 최소 mysql 설치 할때 kim , 1234 로 설정
- mysql -u root -p
- create database addb;
- show databases;
- use mysql;
- grant insert, update, select, delete, create, drop, alter
-    -> on addb.* to 'kim'@'%' identified by '1234';
-
- grant insert, update, select, delete, create, drop, alter
    -> on addb.* to 'park'@'localhost' identified by '1234';

- flush privileges;
- quit

mysql -u root -p
use addb;
create table test(
    -> id int not null auto_increment,
    -> name varchar(50) not null,
    -> address varchar(60),
    -> birth varchar(40),
    -> primary key(id)
    -> );
alter table test change birth birthym varchar(40);
desc test;
alter table test convert to charset utf8;
insert into test(name, address, birthym) values(
    -> 'smart', '경기도', '00년9월');
select * from test;
alter table test add dept varchar(40);
update test set dept='스마트' where id=1;
