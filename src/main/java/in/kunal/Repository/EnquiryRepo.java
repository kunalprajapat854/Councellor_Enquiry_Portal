package in.kunal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {

	public List<Enquiry> findByCouncellorId(Integer councellorId);

}
