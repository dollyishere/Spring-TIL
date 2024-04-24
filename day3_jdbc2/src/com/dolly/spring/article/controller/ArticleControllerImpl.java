package com.dolly.spring.article.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dolly.spring.article.service.ArticleService;
import com.dolly.spring.article.vo.ArticleVO;

public class ArticleControllerImpl extends MultiActionController implements ArticleController {
	private ArticleService articleService;
	
	public ArticleControllerImpl() {
		System.out.println("public ArticleControllerImpl()");
	} // 기본 생성자 end

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
		System.out.println("this.articleService = articleService;");
	}
	
	@Override
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);
		List<ArticleVO> articlesList = articleService.listArticles();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		
		return mav;
	}

	@Override
	public ModelAndView addArticle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);
		ArticleVO article = new ArticleVO();
		
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		article.setImageFilename(request.getParameter("imageFilename"));
		article.setId(request.getParameter("id"));
		article.setParentNo(Integer.parseInt(request.getParameter("parentNo")));
		
		int result = articleService.addArticle(article);
		if (result < 1) {
			viewName = "articleForm";
		}
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	public ModelAndView articleForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	public ModelAndView articleDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		System.out.println("contextPath ==> " + contextPath);
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		System.out.println("uri ==> " + uri);
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		System.out.println("uri ==> " + uri);
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		System.out.println("begin ==> " + begin);
		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
			// ?는 파라미터 대응
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}System.out.println("end ==> " + end);
		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		System.out.println("fileName ==> " + fileName);
		return fileName;
	}

}
