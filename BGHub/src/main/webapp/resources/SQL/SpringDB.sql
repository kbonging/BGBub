create database SpringDB;
use SpringDB;

######################### 회원 테이블 ######################
create table tb_member(
	MEMBER_IDX INT primary key auto_increment COMMENT '회원 고유 번호',
    MEMBER_EMAIL VARCHAR(60) NOT NULL COMMENT '회원 이메일(아이디)',
    MEMBER_PWD VARCHAR(60) NOT NULL COMMENT '회원 비밀번호',
    MEMBER_NAME VARCHAR(30) NOT NULL COMMENT '회원명',
    DEL_YN CHAR(1) NOT NULL default 'N' comment '삭제여부(Y, N)',
    REG_DATE DATETIME,
    MOD_DATE DATETIME
);
# drop table tb_member;

# 샘플 데이터
INSERT INTO tb_member(MEMBER_EMAIL, MEMBER_PWD, MEMBER_NAME, REG_DATE)
values('bong@gmail.com', '1234', '김봉중',NOW());
INSERT INTO tb_member(MEMBER_EMAIL, MEMBER_PWD, MEMBER_NAME, REG_DATE)
values('lee@gmail.com', '1234', '이창섭',NOW());


select * from tb_member;
###########################################################
######################## 게시판 테이블 #######################
CREATE TABLE TB_BOARD (
    BOARD_IDX INT AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 고유번호', -- 게시글 고유번호
    # BOARD_TYPE VARCHAR(20) COMMENT '게시판 유형',                  	-- 게시판 유형 (예: QNA 등)
    CATEGORY VARCHAR(20) NOT NULL COMMENT '게시글 카테고리',            -- 게시글 카테고리 (예: 기술, 커리어, 기타) 추 후 공통코드로 묶을 예정
    TITLE VARCHAR(255) NOT NULL COMMENT '글제목',             	    -- 게시글 제목
    CONTENT TEXT COMMENT '글 내용',                          		    -- 게시글 내용
    MEMBER_IDX INT NOT NULL COMMENT '작성자 고유번호',           	    -- 작성자 고유번호 (회원 테이블 참조)
    VIEW_COUNT INT DEFAULT 0 COMMENT '조회수',                	    -- 조회수
    DEL_YN CHAR(1) NOT NULL default 'N' comment '삭제여부(Y, N)',
    REG_DATE DATETIME,
    MOD_DATE DATETIME
);

# 샘플 데이터
INSERT INTO TB_BOARD (CATEGORY, TITLE, CONTENT, MEMBER_IDX, VIEW_COUNT, REG_DATE)
VALUES 
('01', '자바 프로그래밍 기초', '자바 프로그래밍의 기초에 대해 설명합니다.', 1, 0, NOW()),
('01', '이력서 작성 팁', '이력서를 잘 작성하는 방법에 대해 공유합니다.', 2, 0, NOW()),
('01', '프로그래밍 대회 일정', '2024년 프로그래밍 대회 일정에 대한 안내입니다.', 1, 0, NOW());


