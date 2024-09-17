package flightbooking.flightbooking.repository;

import org.springframework.data.repository.CrudRepository;
import flightbooking.flightbooking.entity.*;


public interface UserRepository extends CrudRepository<User, String> {
  public User findByAadhar(String aadhar);

  public User findByEmail(String email);
}
