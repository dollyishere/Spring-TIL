package com.dolly.spring.article.vo;

import java.sql.Date;

/** article 객체 **/
public class ArticleVO {

    /* articleno       NUMBER(10,0), // article no
    parentno        NUMBER(10,0) DEFAULT 0, parentno (기사 작성자 번호?)
    title           VARCHAR2(500 BYTE), 기사 제목
    content         VARCHAR2(500 BYTE), 기사 내용
    imagefilename   VARCHAR2(30 BYTE), 이미지 파일명
    writedate       DATE DEFAULT SYSDATE, 작성일자
    id              VARCHAR2(10 BYTE), 아이디
    PRIMARY KEY ( articleno )
    */
	
	private int articleNo;
	private int parentNo;
	private String title;
	private String content;
	private String imageFilename;
	private Date writeDate;
	private String id;

	public ArticleVO() {
	} // 생성자 end

	// getters & setters
	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getParentNo() {
		return parentNo;
	}

	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
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

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ArticleVO [articleNo=" + articleNo + ", parentNo=" + parentNo + ", title=" + title + ", content="
				+ content + ", imageFilename=" + imageFilename + ", writeDate=" + writeDate + ", id=" + id + "]";
	}
}
