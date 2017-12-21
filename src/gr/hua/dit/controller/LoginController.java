package gr.hua.dit.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
	public String loginUser(HttpServletRequest request, @ModelAttribute("user") User user, HttpServletResponse response)
			throws ServletException, IOException {
		// save the customer using the service
		User loguser = loginService.loginUser(request.getParameter("username"));

		if (loguser == null) {
			request.setAttribute("message", "This user does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login-form.jsp");
			rd.forward(request, response);
			return "redirect:showLoginForm";
		} else {
			if (loguser.getPassword().equals(request.getParameter("password"))) {
				if (loguser.getRole().equals("Administrator")) {
					return "redirect:/user/adminForm";
				} else if (loguser.getRole().equals("Secretariat")) {
					return "redirect:/user/secretariatForm";
				} else {
					return "redirect:/user/technicianForm";
				}
			} else {
				request.setAttribute("message", "Incorrect password");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login-form.jsp");
				rd.forward(request, response);
				// return to the login form
				return "redirect:showLoginForm";
			}
		}

	}

}
