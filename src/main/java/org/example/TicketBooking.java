package org.example;

import java.io.Serializable;

public class TicketBooking implements Identifiable {
    private String id;
    private Customer customer;
    private Movie movie;
    private Status status;

    public TicketBooking(String id, Customer customer, Movie movie, Status status) {
        this.id = id;
        this.customer = customer;
        this.movie = movie;
        this.status = Status.CREATED;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.equals(id))) return false;
        TicketBooking that = (TicketBooking) o;
        return id.equals(that.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
