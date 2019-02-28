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
        ticketRepo.delete(id);
    }


    public Ticket getById(Integer id) throws IOException {
        return ticketRepo.getById(id);
    }
}
