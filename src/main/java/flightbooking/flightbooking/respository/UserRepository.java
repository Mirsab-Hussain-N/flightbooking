package flightbooking.flightbooking.respository;

import org.springframework.data.repository.CrudRepository;
import flightbooking.flightbooking.entity.*;


public interface UserRepository extends CrudRepository<User, String>{
    public User findByUsername(String username);
    //whenever we pass a Dummy it will return the respective Dummy value from the database
}   

