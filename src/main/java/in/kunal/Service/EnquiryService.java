package in.kunal.Service;

import java.util.List;

import in.kunal.Binding.ViewEnqResquest;
import in.kunal.Entity.Enquiry;

public interface EnquiryService {
	
	public Enquiry editEnq(Integer EnqId);
	
	public boolean addEquiry (Integer councellorId , Enquiry enquiry) throws Exception;
	
	public List<Enquiry> getallEnquiry (Integer councellorId);
	
	public List<Enquiry> viewenqrequest(ViewEnqResquest enqResquest , Integer councellorId);

}
