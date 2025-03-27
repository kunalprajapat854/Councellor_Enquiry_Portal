package in.kunal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {

}
