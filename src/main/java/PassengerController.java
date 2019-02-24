import java.io.IOException;
import java.util.List;

public class PassengerController {
    PassengerRepo PassengerRepo = new PassengerRepoImpl();

    public void save(Passenger passenger) throws IOException {
        PassengerRepo.save(passenger);
    }

    public List<Passenger> findAll() throws IOException {
        return PassengerRepo.findAll();
    }

    public void delete(Integer id) {
        PassengerRepo.delete(id);
    }

    public Passenger getById(Integer id) {
        return PassengerRepo.getById(id);
    }
}
