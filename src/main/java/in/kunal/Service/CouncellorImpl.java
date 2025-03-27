package in.kunal.Service;

import org.springframework.stereotype.Service;

import in.kunal.Binding.DashboardResponse;
import in.kunal.Entity.Councellor;
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
		DashboardResponse dashboardres = new DashboardResponse();

		return null;
	}

}
