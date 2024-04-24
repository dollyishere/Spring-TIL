package com.dolly.spring.article.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.article.vo.ArticleVO;

public interface ArticleService {
	public List<ArticleVO> listArticles() throws DataAccessException;
	public int addArticle(ArticleVO article) throws DataAccessException;
	public ArticleVO articleDetail() throws DataAccessException;
	
}
