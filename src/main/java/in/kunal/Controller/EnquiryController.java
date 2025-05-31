package in.kunal.Controller;

import java.util.List;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.kunal.Binding.ViewEnqRequest;
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
		model.addAttribute("enquiry", new Enquiry());
		return "enquiry";
	}

	@GetMapping("/viewEnq")
	public String viewenquiry(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		
		// Get the existing counselor ID from the session
		Integer councellorId = (Integer) session.getAttribute("councellorId");
		List<Enquiry> enqlist = enquiryservice.getallEnquiry(councellorId);
		model.addAttribute("enqlist", enqlist);
		
		
		//  view enqrequest binding class.
		ViewEnqRequest   filterReq = new ViewEnqRequest();
		model.addAttribute("viewEnqFilter", filterReq);
		return "viewEnq";
	}
	
	@PostMapping("/filter-enq")
	public String filterEnquries(HttpServletRequest request , Model model , ViewEnqRequest viewEnqFilter) {
		HttpSession session = request.getSession(false);
		Integer councellorId = (Integer)session.getAttribute("councellorId");
		System.out.println(councellorId);
		
		List<Enquiry>  enqslist = enquiryservice.viewenqrequest(viewEnqFilter, councellorId);
		model.addAttribute("enqlist", enqslist);
		model.addAttribute("viewEnqFilter", new ViewEnqRequest());

		return "viewEnq";
	}
	
	@GetMapping("/editEnq")
	public String editEnq(Model model , @RequestParam("enqId") Integer enqId) {
		Enquiry editEnq = enquiryservice.editEnq(enqId);
		model.addAttribute("enquiry", editEnq);
		return "enquiry";
	}
	
	

}
