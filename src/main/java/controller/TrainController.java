package controller;

import model.Train;
import repository.TrainRepo;
import repository.TrainRepoImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class TrainController {
    TrainRepo tr = new TrainRepoImpl();

    public void save(Train train) throws IOException {
        if(train == null){
            throw  new IllegalArgumentException();
        }else tr.save(train);
    }

    public List<Train> findAll() throws IOException {
        return tr.findAll();
    }

    public void delete(Integer id) throws IOException {
        if(id == null || id < 0) {
            throw new IllegalArgumentException();
        }else tr.delete(id);
    }

    public Train getById(Integer id) throws IOException {
        if(id == null || id < 0) {
            throw new IllegalArgumentException();
        }else return tr.getById(id);
    }

    public List<Train> generalSearch(String departurePlace, String arrivalPlace, LocalDate departureDate)
            throws IOException {
        if(departurePlace == null || arrivalPlace == null|| departureDate== null ){
            throw new IllegalArgumentException();
        } else {
            return tr.generalSearch(departurePlace, arrivalPlace, departureDate);
        }
    }
}

