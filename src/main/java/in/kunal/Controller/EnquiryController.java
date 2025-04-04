package in.kunal.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.kunal.Entity.Enquiry;
import in.kunal.Service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	private EnquiryService enquiryservice;

	// constructor injection
	public EnquiryController(EnquiryService enquiryservice) {
		super();
		this.enquiryservice = enquiryservice;
	}

	@GetMapping("/enquiry")
	public String loadaddEnqpage(Model model) {
		Enquiry enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);
		return "enquiry";
	}

	@PostMapping("/enquiry")
	public String handleAddEnq(Model model, Enquiry enquiry, HttpServletRequest request) throws Exception {

	    HttpSession session = request.getSession(false);
	    
	    // Get the existing counselor ID from the session
	    Integer councellorId = (Integer) session.getAttribute("councellorId");
	    System.out.println("Councellor ID: " + councellorId);

	    boolean enq = enquiryservice.addEquiry(councellorId, enquiry);
	    if (enq) {
	        model.addAttribute("smsg", "Enquiry Added");
	    } else {
	        model.addAttribute("emsg", "Enquiry Not Added");
	    }
	    return "enquiry";
	}

}
