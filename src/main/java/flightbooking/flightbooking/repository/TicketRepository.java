// package trainbookingapp.trainbookingapp.repository;
package flightbooking.flightbooking.repository;

import org.springframework.data.repository.CrudRepository;
//import trainbookingapp.trainbookingapp.entity.Ticket;
import flightbooking.flightbooking.entity.*;

public interface TicketRepository extends CrudRepository<Ticket, String> {
  public Ticket findByPnr(String pnr);

  public Iterable<Ticket> findAllByEmail(String email);
}
