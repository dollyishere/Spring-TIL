package com.dolly.spring.util;

import javax.servlet.http.HttpServletRequest;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public static String getViewName(HttpServletRequest request) throws Exception {
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
