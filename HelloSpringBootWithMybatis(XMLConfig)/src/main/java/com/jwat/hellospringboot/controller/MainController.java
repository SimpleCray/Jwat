package com.jwat.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jwat.hellospringboot.entity.JsonResponse;
import com.jwat.hellospringboot.entity.UserEntity;
import com.jwat.hellospringboot.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService UserService;

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView login(UserEntity loginForm, Model model) {

		UserEntity user = UserService.selectUserByUsername(loginForm.getUsername());
		if (user == null) {
			model.addAttribute("loginError", "Wrong username or password !");
			System.out.println(loginForm.getUsername());
			return new ModelAndView("login");
		} else if (!user.getPassword().equals(loginForm.getPassword())) {
			model.addAttribute("loginError", "Wrong username or password !");
			System.out.println(user.getPassword());
			return new ModelAndView("login");
		}

		ModelAndView modelView = new ModelAndView("home");
		modelView.addObject("user", loginForm);
		return modelView;
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView home(UserEntity user) {

		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public ModelAndView registration() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	@PostMapping(value = "/registrationAJAX")
	@ResponseBody
	public JsonResponse RegistrationAJAX(UserEntity userForm) {
		JsonResponse res = new JsonResponse();
		UserEntity user = UserService.selectUserByUsername(userForm.getUsername());
		UserEntity email = UserService.selectUserByEmail(userForm.getEmail());
		if (user != null) {
			res.setUserNameError("This username is used !");
		}
		if (email != null) {
			res.setEmailError("This email is used !");
		}
		if(user == null && email == null) {
			UserService.insertUser(userForm);
			res.setSuccessMessage("Registration successful! You will be redirected to login page after 5 seconds!");
		}
		return res;
	}
	
	@RequestMapping(value = { "/userlist"}, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("listUser");
		List<UserEntity> userList = UserService.selectAllUser();
		mav.addObject("userList", userList);
		return mav;
	}

}