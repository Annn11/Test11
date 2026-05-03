package org.example;
import java.util.List;
import java.util.Optional;
public class Main {
    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        TicketBookingService ticketBookingService = new TicketBookingService();
        Customer customer = new Customer("c1", "Anna", "+380999994343");
        Movie movie = new Movie("m1", "Terminator");
        ticketBookingService.activateBooking("m1");
        List<TicketBooking> list = ticketBookingService.findActiveBooking();
        System.out.println(list);
    }
}