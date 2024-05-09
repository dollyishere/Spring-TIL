package com.dolly.spring.article.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ArticleController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addArticle(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView articleForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView articleDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
