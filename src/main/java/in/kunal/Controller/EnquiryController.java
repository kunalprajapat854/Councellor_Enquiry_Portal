package in.kunal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.kunal.Entity.Enquiry;
import in.kunal.Service.CouncellorService;
import in.kunal.Service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	private EnquiryService enquiryservice;
	private CouncellorService councellorservice;

	// constructor injection
	public EnquiryController(EnquiryService enquiryservice, CouncellorService councellorservice) {
		super();
		this.enquiryservice = enquiryservice;
		this.councellorservice = councellorservice;
	}

	@GetMapping("/enquiry")
	public String loadaddEnqpage(Model model) {
		Enquiry enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);
		return "enquiry";
	}

	@PostMapping("/enquiry")
	public String handleAddEnq(Model model, Enquiry enquiry, HttpServletRequest request) throws Exception {

		//get the existing councellor Id for the session 
		HttpSession session = request.getSession(false);
		Integer councellorId = (Integer) session.getAttribute("councellorId");
		
		boolean enq = enquiryservice.addEquiry(councellorId, enquiry);
		if(enq) {
			model.addAttribute("smsg", "Equiry Added");
		} else {
			model.addAttribute("emsg", "Enquiry Not Added");
		}
		return "enquiry";
	}

}
