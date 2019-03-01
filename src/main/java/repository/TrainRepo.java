package repository;

import model.Train;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface TrainRepo extends GenericRepo<Train,Integer> {
    List<Train> generalSearch(String departurePlace, String arrivalPlace, LocalDate departureDate) throws IOException;
}
