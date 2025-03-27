package in.kunal.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.kunal.Binding.DashboardResponse;
import in.kunal.Entity.Councellor;
import in.kunal.Entity.Enquiry;
import in.kunal.Repository.CouncellorRepo;
import in.kunal.Repository.EnquiryRepo;

@Service
public class CouncellorImpl implements CouncellorService {

	private CouncellorRepo councellorrepo;

	private EnquiryRepo enquiryrepo;

	public CouncellorImpl(CouncellorRepo councellorrepo, EnquiryRepo enquiryrepo) {
		this.councellorrepo = councellorrepo;
		this.enquiryrepo = enquiryrepo;
	}

	public boolean register(Councellor councellor) {
		Councellor save = councellorrepo.save(councellor);
		if (save.getCouncellorId() != null) {
			return true;
		}
		return false;
	}

	public Councellor login(String email, String password) {
		Councellor emailAndPassword = councellorrepo.findByEmailAndPassword(email, password);
		return emailAndPassword;
	}

	public DashboardResponse dashboard(Integer councellorId) {
		DashboardResponse response = new DashboardResponse();
		 List<Enquiry> enquiry = enquiryrepo.findByCouncellorId(councellorId);
		 int totalEnq = enquiry.size();
		 
		 int enrolledEnq = enquiry.stream().filter(e-> e.getStatus().equals("Enrolled"))
		 .collect(Collectors.toList())
		 .size();
		 
		 int lostEnq = enquiry.stream().filter(e-> e.getStatus().equals("Lost"))
		 .collect(Collectors.toList())
		 .size();
		 
		 int openEnq = enquiry.stream().filter(e-> e.getStatus().equals("Open"))
		 .collect(Collectors.toList())
		 .size();
		 
		 response.setTotalEnq(totalEnq);
		 response.setEnrollEnq(enrolledEnq);
		 response.setOpenEnq(openEnq);
		 response.setLostEnq(lostEnq);
		 
		 
		return response;
	}

	public Councellor duplicateEmailCheck(String email) {
		Councellor emailcheck = councellorrepo.duplicateEmailCheck(email);
		if(emailcheck!=null) {
			return  emailcheck;
		}
		return null;
	}

}
