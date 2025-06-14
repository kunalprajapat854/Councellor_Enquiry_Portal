package in.kunal.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.kunal.Entity.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {

	@Query(value = "SELECT * FROM Enquiry WHERE councellor_id= :councellorId" ,nativeQuery =  true)
	public List<Enquiry> findByCouncellorId(Integer councellorId);

}
