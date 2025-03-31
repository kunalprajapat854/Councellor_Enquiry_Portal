package in.kunal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import in.kunal.Binding.ViewEnqResquest;
import in.kunal.Entity.Councellor;
import in.kunal.Entity.Enquiry;
import in.kunal.Repository.CouncellorRepo;
import in.kunal.Repository.EnquiryRepo;
import io.micrometer.common.util.StringUtils;

@Service
public class EnquiryImpl implements EnquiryService {

	private CouncellorRepo councellorrepo;
	private EnquiryRepo enquiryrepo;

	public EnquiryImpl(CouncellorRepo councellorrepo, EnquiryRepo enquiryrepo) {
		this.councellorrepo = councellorrepo;
		this.enquiryrepo = enquiryrepo;
	}

	public List<Enquiry> getallEnquiry(Integer councellorId) {
		List<Enquiry> getCouncellorId = enquiryrepo.findByCouncellorId(councellorId);
		return getCouncellorId;

	}

	public List<Enquiry> viewenqrequest(ViewEnqResquest enqrequest, Integer councellorId) {
//		QBE implementation
		Enquiry enquiry = new Enquiry();

		// generating dynamic queary using Spring Data Jpa QBE concept!
		if (StringUtils.isNotEmpty(enqrequest.getClassMode())) {
			enquiry.setClassMode(enqrequest.getClassMode());
		}
		if (StringUtils.isNotEmpty(enqrequest.getCourse())) {
			enquiry.setCourse(enqrequest.getCourse());
		}
		if (StringUtils.isNotEmpty(enqrequest.getStatus())) {
			enquiry.setStatus(enqrequest.getStatus());
			System.out.println(enqrequest.getStatus());
		}

		Councellor councellor = councellorrepo.findById(councellorId).orElse(null);
		enquiry.setCouncellorId(councellor);

		Example<Enquiry> of = Example.of(enquiry);
		List<Enquiry> allEnq = enquiryrepo.findAll(of);
		return allEnq;
	}

	public boolean addEquiry(Integer councellorId, Enquiry enquiry) throws Exception {
		Councellor councellor = councellorrepo.findById(councellorId).orElse(null);
		if (councellor == null) {
			throw new Exception("NO Councellor Found!");
		}
		enquiry.setCouncellorId(councellor);

		Enquiry save = enquiryrepo.save(enquiry);
		if (save.getEnquiryId() != null) {
			return true;
		}
		return false;
	}

	public Enquiry editEnq(Integer EnqId) {
		Optional<Enquiry> id = enquiryrepo.findById(EnqId);
		if(id!=null) {
			return id.get();
		}
		return null;
		   
	}

}
