package gr.hua.dit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.User;
import gr.hua.dit.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/showLoginForm")
	public String showLoginForm(HttpServletRequest request, Model model, HttpServletResponse response) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Login");
		return "login-form";
	}

	@RequestMapping("/loginForm")
	public String loginUser(HttpServletRequest request, @ModelAttribute("user") User user) {
		// save the customer using the service
		User loguser = loginService.loginUser(request.getParameter("username"));

		String username = request.getParameter("username");
		if (loguser == null) {
			request.setAttribute("loginResult", true);
			return "redirect:showLoginForm";
		} else {
			if (loguser.getPassword().equals(request.getParameter("password"))) {
				System.out.println("correct password");
				if (loguser.getRole().equals("Administrator")) {
					return "admin-form";
				} else if (loguser.getRole().equals("Secretariat")) {
					return "secretariat-form";
				} else {
					return "technician-form";
				}
			} else {
				System.out.println("Wrong password");
				// return to the login form
				return "redirect:showLoginForm";
			}
		}

	}
	

	@GetMapping("/adminForm")
	public String adminForm(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Admin");
		return "admin-form";
	}
	

	@GetMapping("/technicianForm")
	public String technicianForm(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Technician");
		return "technician-form";
	}

	@GetMapping("/secretariatForm")
	public String secretariatForm(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Secretariat");
		return "secretariat-form";
	}
}