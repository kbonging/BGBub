package com.SpringProject.board.vo;

import com.SpringProject.cmm.DefaultVO;

public class BoardVO extends DefaultVO{
	
	private String boardIdx="";      // 게시글 고유번호
    private String category = ""; // 게시글 카테고리
    private String title = "";    // 글 제목
    private String content = "";  // 글 내용
    private String memberIdx="";      // 작성자 고유번호
    private String viewCount="";      // 조회수
    
	public String getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(String boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(String memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardIdx=" + boardIdx + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", memberIdx=" + memberIdx + ", viewCount=" + viewCount + "]";
	}
    
	
}
