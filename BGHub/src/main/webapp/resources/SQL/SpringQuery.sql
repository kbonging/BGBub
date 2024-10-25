############  게시글 목록 조회 ###########
SELECT 
    BOARD_IDX AS boardIdx,
    CATEGORY AS category,
    TITLE AS title,
    CONTENT AS content,
    MEMBER_IDX AS memberIdx,
    VIEW_COUNT AS viewCount,
    DEL_YN AS delYn,
    REG_DATE AS regDate,
    MOD_DATE AS modDate
FROM 
    TB_BOARD
WHERE 
    DEL_YN = 'N';
#########################################

select * from tb_member;

SELECT * FROM tb_member 
        WHERE MEMBER_EMAIL = 'bong@gmail.com' AND DEL_YN = 'N'
  