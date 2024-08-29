package flightbooking.flightbooking.respository;

import org.springframework.data.repository.CrudRepository;
import flightbooking.flightbooking.entity.*;

public interface DummyRepository extends CrudRepository<Dummy, Integer>{
    public Dummy findById(int id);
    //whenever we pass a Dummy it will return the respective Dummy value from the database
}

