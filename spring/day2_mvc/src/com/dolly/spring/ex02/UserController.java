package com.dolly.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/** multi-action controller 상속받을 거임~ **/
public class UserController extends MultiActionController {

	public UserController() {
		
	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String userID = "";
		String passwd = "";
		String viewName = getViewName(request);
		System.out.println("viewName ===> " + viewName);
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		
		// 2. addObject로 보낼 값 넣어주고, setViewName으로 view 이름 넣어주기
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
//		mav.setViewName("result"); // 3.
		mav.setViewName(viewName); // 3.
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		String viewName = getViewName(request);
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// 2. addObject로 보낼 값 넣어주고, setViewName으로 view 이름 넣어주기
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		mav.setViewName(viewName); // 3. view 이름 세팅
		return mav;
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
