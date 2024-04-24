package com.dolly.spring.article.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dolly.spring.article.dao.ArticleDAO;
import com.dolly.spring.article.vo.ArticleVO;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDAO articleDAO;

	public ArticleServiceImpl() {
		System.out.println("public ArticleServiceImpl()");
	} // 기본 생성자 end

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
		System.out.println("this.articleDAO = articleDAO;");
	}
	
	@Override
	public List<ArticleVO> listArticles() throws DataAccessException {
		System.out.println("public List<ArticleVO> listArticles() throws DataAccessException");
		List<ArticleVO> articlesList = null;
		articlesList = articleDAO.selectAllArticles();
		
		return articlesList;
	}

	@Override
	public int addArticle(ArticleVO article) throws DataAccessException {
		System.out.println("public int addArticle(ArticleVO article) throws DataAccessException");
		int result = articleDAO.addArticle(article);
		return result;
	}

	@Override
	public ArticleVO articleDetail() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
