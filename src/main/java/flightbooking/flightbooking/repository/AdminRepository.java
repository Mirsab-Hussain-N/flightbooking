package flightbooking.flightbooking.repository;

import org.springframework.data.repository.CrudRepository;
import flightbooking.flightbooking.entity.*;


public interface AdminRepository extends CrudRepository<admin, String> {
  public admin findByAadhar(String aadhar);

  public admin findByEmail(String email);
}
