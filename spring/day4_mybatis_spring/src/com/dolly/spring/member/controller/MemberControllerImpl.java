package com.dolly.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dolly.spring.member.service.MemberService;
import com.dolly.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public MemberControllerImpl() {
		System.out.println("public MemberControllerImpl()");
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		
		ModelAndView mav = new ModelAndView("member/" + viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}


	@Override
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView("member/" + viewName);
		return mav;
	}
	
	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "member/" + getViewName(request);
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId(request.getParameter("id"));
		memberVO.setEmail(request.getParameter("email"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setPwd(request.getParameter("pwd"));
		
		int result = memberService.addMember(memberVO);
		
		if (result < 0) {
			viewName = "errLog";
		} else {
			viewName = "member/redirect";
		}
		
		ModelAndView mav = new ModelAndView(viewName);
		
		
		return mav;
	}

	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		int result = memberService.removeMember(request.getParameter("id"));
		
		if (result < 0) {
			viewName = "errLog";
		} else {
			viewName = "member/redirect";
		}
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}


	@Override
	public ModelAndView modMemberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "member/" +  getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		
		MemberVO memberVO = memberService.modMemberForm(request.getParameter("id"));
		mav.addObject("member", memberVO);
		
		return mav;
	}
	
	@Override
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = "";
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId(request.getParameter("id"));
		memberVO.setEmail(request.getParameter("email"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setPwd(request.getParameter("pwd"));
		
		int result = memberService.modMember(memberVO);
		
		if (result < 0) {
			viewName = "errLog";
		} else {
			viewName = "member/" + "redirect";
		}
		
		mav.setViewName(viewName);
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
