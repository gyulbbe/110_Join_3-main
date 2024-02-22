package com.feb.jdbc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.service.JoinService;

@Controller
public class JoinController {

	@Autowired
	private JoinService joinService;
	
	//회원가입 페이지 이동
	@GetMapping("/index.do")
	public String goLoginForm() {
		return "login";
	}
	
	//회원가입
	@PostMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		//회원가입 시 result에 1대입
		int result = joinService.join(params);
		//회원가입 성공, 실패 여부 메시지
		if(result ==1) {
			mv.addObject("msg", "회원가입 성공");
		}
		else {
			mv.addObject("msg", "회원가입 실패");
		}
		
		//메시지 전달 후 로그인 페이지로 이동
		mv.setViewName("login");
		return mv;
	}
}
