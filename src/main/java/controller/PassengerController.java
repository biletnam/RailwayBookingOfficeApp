package controller;

import model.Passenger;
import repository.PassengerRepoImpl;

import java.io.IOException;
import java.util.List;

public class PassengerController {
    repository.PassengerRepo PassengerRepo = new PassengerRepoImpl();

    public void save(Passenger passenger) throws IOException {
        if(passenger == null){
            throw  new IllegalArgumentException();
        }else PassengerRepo.save(passenger);
    }



    public List<Passenger> findAll() throws IOException {
        return PassengerRepo.findAll();
    }

    public void delete(Integer id) throws IOException {
        PassengerRepo.delete(id);
    }

    public Passenger getById(Integer id) throws IOException {
        return PassengerRepo.getById(id);
    }
}
