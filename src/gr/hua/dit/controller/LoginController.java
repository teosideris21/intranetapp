package gr.hua.dit.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;
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

		String username = request.getParameter("username");
		if (loguser == null) {
			request.setAttribute("message", "This user does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login-form.jsp");
			rd.forward(request, response);
			return "redirect:showLoginForm";
		} else {
			if (loguser.getPassword().equals(request.getParameter("password"))) {
				if (loguser.getRole().equals("Administrator")) {
					return "admin-form";
				} else if (loguser.getRole().equals("Secretariat")) {
					return "secretariat-form";
				} else {
					return "technician-form";
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

	@RequestMapping("/searchDB")
	public String searchVehicle(HttpServletRequest request, @ModelAttribute("vehicleDB") Vehicle vehicle,
			HttpServletResponse response) {

		Vehicle vhcl = loginService.checkDB(request.getParameter("id"));

		if (vhcl == null) {

			System.out.println("This vehicle does not exist into DB");
			return "redirect:secretariatForm";

		} else {
			if (vhcl.getInsurance().equals("yes")) {
				System.out.println("Successfull check");
				if (vhcl.getType().equals("car")) {
					if (vhcl.getSub_type() > 1800) {
						System.out.println("80$");
						return "redirect:secretariatForm";
					} else {
						System.out.println("50$");
						return "redirect:secretariatForm";
					}
				} else {
					if (vhcl.getSub_type() > 3) {
						System.out.println("150$");
						return "redirect:secretariatForm";
					} else {
						System.out.println("100$");
						return "redirect:secretariatForm";
					}
				}

			} else {
				System.out.println("Uninsured vehicle");
				System.out.println("200$");
				return "redirect:secretariatForm";
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

	@RequestMapping("/createUser")
	public String createUser(HttpServletRequest request, @ModelAttribute("user") User user) {
		loginService.saveUser(user);
		return "redirect:/login/adminForm";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request, @ModelAttribute("user") User user,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			loginService.deleteUser(user);
		} catch (java.lang.IllegalArgumentException e) {
			request.setAttribute("message", "Username does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin-form.jsp");
			rd.forward(request, response);
		}
		return "redirect:/login/adminForm";
	}

	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request, @ModelAttribute("user") User user) {
		loginService.deleteUser(user);
		return "redirect:/login/UpdateUser";
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

	@GetMapping("/UpdateUser")
	public String userUpdate(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Update");
		return "update-user";
	}
	
	@RequestMapping("/updateUseradd")
	public String updateUseradd(HttpServletRequest request, @ModelAttribute("user") User user) {
		loginService.saveUser(user);
		return "redirect:/login/adminForm";
	}
	
}
