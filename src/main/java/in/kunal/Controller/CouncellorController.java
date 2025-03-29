package in.kunal.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.kunal.Binding.DashboardResponse;
import in.kunal.Entity.Councellor;
import in.kunal.Service.CouncellorService;

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
	public String handlelogin(Model model, Councellor councellor) {
		Councellor login = councellorservice.login(councellor.getEmail(), councellor.getPassword());
		if (login == null) {
			model.addAttribute("emsg", "Invalid Credentials");
			model.addAttribute("login", new Councellor());
			return "index";
		} else {
			DashboardResponse dashboardResponse = new DashboardResponse();
			model.addAttribute("dashboardobj", dashboardResponse);
			return "dashboard";
		}
	}

}
