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
	
	//사용자 포인트 읽기
	@RequestMapping("/getPoint")
	@ResponseBody
	public int getPoint(String uid){
		UserVO vo=dao.read(uid);
		return vo.getPoint();
	}
	
	//사용자 목록
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("list", dao.list());
		model.addAttribute("pageName", "user/list.jsp");
		return "/home";
	}
	
	//보낸메시지
	@RequestMapping("/send")
	public String send(Model model, String uid) {
		model.addAttribute("list", dao.list());
		model.addAttribute("vo" ,dao.read(uid));
		model.addAttribute("pageName","user/send.jsp");
		return "/home";
	}
	
	//받은메시지
	@RequestMapping("/receive")
	public String receive(Model model, String uid){
		model.addAttribute("vo" , dao.read(uid));
		model.addAttribute("pageName","user/receive.jsp");
		return "/home";
	}
	
	@RequestMapping("/read")
	public String read(Model model , String uid) {
		model.addAttribute("pageName" , "user/read.jsp");
		model.addAttribute("vo" , dao.read(uid));
		return "/home";
	}
	
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