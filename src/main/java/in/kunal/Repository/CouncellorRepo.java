package in.kunal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.kunal.Entity.Councellor;

public interface CouncellorRepo extends JpaRepository<Councellor, Integer> {

	@Query(value = "SELECT * FROM councellor WHERE email= :email AND password= :password", nativeQuery = true)
	public Councellor findByEmailAndPassword(String email, String password);

	@Query(value = "SELECT * FROM councellor WHERE email:= email", nativeQuery = true)
	public Councellor duplicateEmailCheck(String email);

}
