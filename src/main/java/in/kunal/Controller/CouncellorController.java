package in.kunal.Controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.kunal.Binding.DashboardResponse;
import in.kunal.Entity.Councellor;
import in.kunal.Service.CouncellorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CouncellorController {

	@Autowired
	private CouncellorService councellorservice;

	@GetMapping("/")
	public String loadloginPage(Model model) {
		Councellor councellor = new Councellor();
		model.addAttribute("login", councellor);
		return "index";
	}

	@PostMapping("/login")
	public String handlelogin(Model model, Councellor councellor, HttpServletRequest request) {
		Councellor login = councellorservice.login(councellor.getEmail(), councellor.getPassword());
	
		if (login == null) {
			model.addAttribute("emsg", "Invalid Credentials");
			model.addAttribute("login", new Councellor());
			return "index";

		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("councellorId", login.getCouncellorId());
			System.out.println("councellorId" + login.getCouncellorId());
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/register")
	public String loadregister(Model model) {
		Councellor councellor = new Councellor();
		model.addAttribute("register", councellor);
		return "register";
	}
	
	@PostMapping("/register")
	public String handleregister(Model model , Councellor councellor) {
		Councellor emailCheck = councellorservice.duplicateEmailCheck(councellor.getEmail());
		if(emailCheck!=null) {
			model.addAttribute("emsg", "Duplicate Email");
			model.addAttribute("register", new Councellor());
			return "register";
		}
		
		boolean register = councellorservice.register(councellor);
		if(register) {
			model.addAttribute("smsg", "Registration Success");
			return "redirect:/dashboard";
		} else {
			model.addAttribute("emsg", "Registration Failed");
		}
		return null;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String showdashboard(HttpServletRequest request , Councellor councellor , Model model) {
		HttpSession session = request.getSession(false);
		Integer councellorId = (Integer)session.getAttribute("councellorId");
		
		DashboardResponse dashboardResponse = councellorservice.dashboard(councellorId);
		System.out.println("Counsellor ID set in session: " + councellor.getCouncellorId());

		model.addAttribute("dashboardobj", dashboardResponse);
		return "dashboard";
		
	}

}
