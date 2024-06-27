package com.chainsys.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.spring.dao.RegisterDAO;
import com.chainsys.spring.dao.UserDAO;
import com.chainsys.spring.model.Details;





@Controller
public class ControllerDemo {
	
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping("/home")
	public String home(){
		
		return "firstPage.jsp";

	}
	@PostMapping("/register")
	public String register(@RequestParam("name")String name,@RequestParam("mail")String mail,
			@RequestParam("phone")String phone,@RequestParam("pass")String pass , Model model) {
		Details details=new Details();

		details.setName(name);
		details.setMail(mail);
		details.setPhone(phone);
		details.setPassword(pass);
		
		userDAO.insert(details);
		
		System.out.println(details.getName()+details.getMail()+details.getMail()+
				details.getPhone()+details.getPassword());
		
//		List<Details> list=register.read();
//		
//		model.addAttribute("values", list);
//		
		return "signedUp.jsp";

}
	
	@PostMapping("/view")
	public String view(Model model) {
		
 List<Details> list=userDAO.read();
		
		model.addAttribute("values", list);
		
		return "secondPage.jsp";
	}

	@PostMapping("/update")
	public String update(@RequestParam("name")String name,@RequestParam("mail")String mail,
			@RequestParam("phone")String phone,@RequestParam("pass")String pass  , Model model){
		
		Details details=new Details();

		details.setName(name);
		details.setMail(mail);
		details.setPhone(phone);
		details.setPassword(pass);
		
		
		int updatedRows=userDAO.update(details);
		System.out.println("updated rows"+updatedRows);
      List<Details> list=userDAO.read();
		
		model.addAttribute("values", list);
		
		return "secondPage.jsp";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("mail")String mail, Model model){
		
		Details details=new Details();

		details.setMail(mail);
		
		userDAO.delete(details);
		
	
      List<Details> list=userDAO.read();
		
		model.addAttribute("values", list);
		
		return "secondPage.jsp";
}
	@GetMapping("/search")
	public String search(@RequestParam("name")String name, Model model){
		
		Details details=new Details();

		details.setName(name);
	
      List<Details> list=userDAO.search(details);
		
		model.addAttribute("values", list);
		
		return "secondPage.jsp";
}
	
	@PostMapping("/login")
	public String login(@RequestParam("mail")String mail,@RequestParam("pass")String pass){
		Details details=new Details();
		System.err.println("loginnnnnnnnnnn");
		details.setMail(mail);
		details.setPassword(pass);
		
		System.out.println("---->" + userDAO.check(details));
		if(userDAO.check(details)==true) {
			
			return "login.jsp";
			
		}else {
			return "failed.jsp";
		}
				
		
		
	}
	
}
