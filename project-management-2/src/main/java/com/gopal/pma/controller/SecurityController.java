package com.gopal.pma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gopal.pma.dao.UserAccountRepository;
import com.gopal.pma.entity.UserAccount;

@Controller
public class SecurityController {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	UserAccountRepository userAccountRepo;
	
	@RequestMapping("/register")
	public String register(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount", userAccount);
		return "security/register";
	}
	
	@RequestMapping("/register/save")
	public String saveUser(Model model, UserAccount userAccount) {
		userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
		userAccountRepo.save(userAccount);
		return "redirect:/"; 
		// we need CSRL protection. or form submit needs to have thymeleaf @url format or send csrf token as hidden field
	}

}
