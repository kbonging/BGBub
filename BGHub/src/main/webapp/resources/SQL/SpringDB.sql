create database SpringDB;

create table member(
	MEMBER_IDX INT primary key auto_increment COMMENT '회원 고유 번호',
    MEMBER_EMAIL VARCHAR(60) NOT NULL COMMENT '회원 이메일(아이디)',
    MEMBER_PWD VARCHAR(60) NOT NULL COMMENT '회원 비밀번호',
    MEMBER_NAME VARCHAR(30) NOT NULL COMMENT '회원명',
    DEL_YN CHAR(1) NOT NULL default 'N' comment '삭제여부(Y, N)',
    REG_ID VARCHAR(100),
    REG_NAME VARCHAR(60),
    REG_DATE DATETIME,
    MOD_ID VARCHAR(100),
    MOD_NAME VARCHAR(60),
    MOD_DATE DATETIME
);
-- drop table member;

INSERT INTO MEMBER(MEMBER_EMAIL, MEMBER_PWD, MEMBER_NAME, REG_DATE)
values('bong@gmail.com', '1234', '김봉중',NOW());
INSERT INTO MEMBER(MEMBER_EMAIL, MEMBER_PWD, MEMBER_NAME, REG_DATE)
values('lee@gmail.com', '1234', '이창섭',NOW());


select * from member;