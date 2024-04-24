package com.dolly.spring.article.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.article.vo.ArticleVO;

public interface ArticleDAO {
	public List<ArticleVO> selectAllArticles() throws DataAccessException;
	public int addArticle(ArticleVO articleVO) throws DataAccessException;
	public List<ArticleVO> articleForm() throws DataAccessException;
	public ArticleVO articleDetail(int articleNo) throws DataAccessException;
}
