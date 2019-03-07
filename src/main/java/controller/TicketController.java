package controller;

import model.Ticket;
import repository.TicketRepo;
import repository.io.TicketRepoImpl;

import java.io.IOException;
import java.util.List;

public class TicketController {
    TicketRepo ticketRepo = new TicketRepoImpl();

    public void save(Ticket ticket) throws IOException {
        ticketRepo.save(ticket);
    }

    public List<Ticket> findAll() throws IOException {
        return ticketRepo.findAll();
    }

    public void delete(Integer id) throws IOException {
        if(id == null || id < 0) {
            throw new IllegalArgumentException();
        }else ticketRepo.delete(id);
    }


    public Ticket getById(Integer id) throws IOException {
        if(id == null || id < 0) {
            throw new IllegalArgumentException();
        }else return ticketRepo.getById(id);
    }
}
