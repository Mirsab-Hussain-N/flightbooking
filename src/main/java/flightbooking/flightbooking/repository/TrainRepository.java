package flightbooking.flightbooking.repository;

import org.springframework.data.repository.CrudRepository;
import flightbooking.flightbooking.entity.*;


public interface TrainRepository extends CrudRepository<Train, String> {
  public Iterable<Train> findAllBySourceAndDestinationAndDate(
    String source,
    String destination,
    String date
  );
}
