--테이블 작성
create table member(
name varchar2(30) not null,
id varchar2(30) primary key, --기본키, unique, not null, 무결성 제약 조건
pwd varchar2(30) not null,
gender varchar2(3),
email1 varchar2(20),
email2 varchar2(20),
tel1 varchar2(10),
tel2 varchar2(10),
tel3 varchar2(10),
zipcode varchar2(10),
addr1 varchar2(100),
addr2 varchar2(100),
logtime date);

--우편번호 테이블 작성
create table newzipcode (
zipcode   varchar2(7),
sido   varchar2(20),
sigungu   varchar2(30),
yubmyundong   varchar2(20), -- 읍면동
ri   varchar2(20),
roadname   varchar2(100),
buildingname   varchar2(100));