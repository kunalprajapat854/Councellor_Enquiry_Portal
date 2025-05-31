package in.kunal.Service;

import java.util.List;

import in.kunal.Binding.ViewEnqRequest;
import in.kunal.Entity.Enquiry;

public interface EnquiryService {
	
	public Enquiry editEnq(Integer EnqId);
	
	public boolean addEquiry (Integer councellorId , Enquiry enquiry) throws Exception;
	
	public List<Enquiry> getallEnquiry (Integer councellorId);
	
	public List<Enquiry> viewenqrequest(ViewEnqRequest enqRequest , Integer councellorId);

}
