package org.example;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
public class TicketBookingService {
    private static Logger logger = Logger.getLogger(TicketBookingService.class.getName());
    private Repository<TicketBooking> ticketBookings = new Repository<>();
    public TicketBooking createBooking(String id, Movie movie, Customer customer, Status status) {
        if (id == null || id.isBlank()) {
            logger.severe("id cannot be blank");
            throw new MovieException("id cannot be blank");
        }
        if (movie == null) {
            logger.severe("movie cannot be null");
            throw new MovieException("movie cannot be null");
        }
        if (customer == null) {
            logger.severe("customer cannot be null");
        }
        TicketBooking ticketBooking = new TicketBooking(id, customer, movie, status);
        ticketBookings.add(ticketBooking);
        return ticketBooking;
    }
    public void activateBooking(String id) {
        TicketBooking ticketBooking = ticketBookings.findById(id)
                .orElseThrow(() -> {
                        logger.severe("ticket booking with id " + id + " not found");
                        return new MovieException("ticket booking not found");
    });
        if(ticketBooking.getStatus() != Status.CREATED) {
            logger.severe("cannot activate ticket booking" +ticketBooking.getStatus());
            throw new MovieException("cannot activate ticket booking");
        }
        ticketBooking.setStatus(Status.CONFIRMED);
        logger.info("activated ticket booking" + id);
    }
    public void deactivateBooking(String id) {
        TicketBooking ticketBooking = ticketBookings.findById(id)
                .orElseThrow(() -> {
                    logger.severe("ticket booking with id " + id + " not found");
                    return new MovieException("ticket booking not found");
                });
        if(ticketBooking.getStatus() != Status.CONFIRMED) {
            logger.severe("cannot deactivate ticket booking" +ticketBooking.getStatus());
            throw new MovieException("cannot deactivate ticket booking");
        }
        ticketBooking.setStatus(Status.CANCELLED);
        logger.info("deactivated ticket booking" + id);
    }
    public Optional<TicketBooking> findById(String id) {
        return ticketBookings.findById(id);
    }
    public List<TicketBooking> findActiveBooking() {
        return ticketBookings.findAll().stream()
                .filter(t -> t.getStatus() != Status.CANCELLED)
                .toList();
    }
}
