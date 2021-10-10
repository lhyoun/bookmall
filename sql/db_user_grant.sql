SELECT * FROM myspring.travel;

create database webdb;
create user webdb@localhost identified by 'webdb';
grant all privileges on webdb.* to webdb@'%';

create database bookmall;
create user 'bookmall'@'%' identified by 'bookmall';

GRANT ALL PRIVILEGES ON bookmall.* TO 'root'@'%' WITH GRANT OPTION;
grant all privileges on bookmall.* to bookmall@'%';

commit;

create user 'myspring'@'%' identified by 'lhyjej1213'; -- '%' : 어떤 ip에서도 접근 가능 / 일반적으로는 localhost 해야 다른 컴퓨터에서 접근 불가능 
GRANT ALL privileges on *.* to 'bookmall'@'%'; -- 모든 권한을 다 주겠다 
create database myspring; -- db 생성 use cos;
use myspring;




create database bookmall;
create user 'bookmall'@'%' identified by 'bookmall';
GRANT ALL privileges on bookmall.* to 'bookmall'@'%'; -- 모든 권한을 다 주겠다 

