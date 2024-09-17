package flightbooking.flightbooking.repository;

import org.springframework.data.repository.CrudRepository;
import flightbooking.flightbooking.entity.*;


public interface UserTicketRepository
  extends CrudRepository<UserTicket, Integer> {
  Iterable<UserTicket> findAllByPnr(String pnr);
}
