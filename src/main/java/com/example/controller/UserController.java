package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDAO dao;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("pageName", "user/login.jsp");
		return "/home";
	}
	
	@RequestMapping("/logout")
	public String login(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public int loginPost(String uid, String upass, HttpSession session){
		int result=0;
		UserVO vo=dao.read(uid);
		if(vo != null) {
			/*if(passEncoder.matches(upass, vo.getUpass())){*/
			if(upass.equals(vo.getUpass())){
				result=1;	
			result=1;
				session.setAttribute("uid", vo.getUid());
			}else{
				result=2;
			}
		}
		return result;
	}
}
