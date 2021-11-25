--테이블
CREATE TABLE product(
     seq NUMBER PRIMARY KEY,               
     img VARCHAR2(200) NOT NULL,   -- 상품 
     name VARCHAR2(40) NOT NULL,   -- 상품명
     unit  NUMBER NOT NULL,        -- 단가
     qty    NUMBER NOT NULL,       -- 개수
     total  NUMBER NOT NULL,       -- 합계
     rate    NUMBER NOT NULL,      -- 할인율
     discount  NUMBER NOT NULL,    -- 할인액
     price    NUMBER NOT NULL      -- 가격
 );

--시퀀스 객체
create sequence seq_product  nocache nocycle;