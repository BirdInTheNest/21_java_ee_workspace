--테이블 작성
create table member(
id varchar2(30) primary key, --기본키, unique, not null, 무결성 제약 조건
pwd varchar2(30) not null,
email1 varchar2(20),
email2 varchar2(20));
