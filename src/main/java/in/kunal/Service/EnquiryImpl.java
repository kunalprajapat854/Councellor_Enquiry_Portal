package in.kunal.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.kunal.Binding.ViewEnqResquest;
import in.kunal.Entity.Enquiry;
import in.kunal.Repository.CouncellorRepo;
import in.kunal.Repository.EnquiryRepo;

@Service
public class EnquiryImpl implements EnquiryService {

	private CouncellorRepo councellorrepo;
	private EnquiryRepo enquiryrepo;

	public EnquiryImpl(CouncellorRepo councellorrepo, EnquiryRepo enquiryrepo) {
		this.councellorrepo = councellorrepo;
		this.enquiryrepo = enquiryrepo;
	}

	public boolean addEquiry(Integer councellorId) {

		return false;
	}

	public List<Enquiry> getallEnquiry(Integer councellorId) {
	
	}

	public List<Enquiry> viewenqrequest(ViewEnqResquest enqResquest, Integer councellorId) {
		return null;
	}

}
