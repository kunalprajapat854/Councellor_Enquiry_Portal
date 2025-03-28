package in.kunal.Controller;

import org.springframework.stereotype.Controller;

import in.kunal.Service.CouncellorService;

@Controller
public class CouncellorController {
	
	private CouncellorService councellorservice;
	
	public CouncellorController (CouncellorService councellorservice) {
		this.councellorservice = councellorservice;
	}
	
	

	
	
	
	

}
