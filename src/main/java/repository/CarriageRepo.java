package repository;

import model.Carriage;

import java.io.IOException;

public interface CarriageRepo extends GenericRepo<Carriage,Integer> {
    void decreaseNumberOfFreeSeats(Integer carriageId,int purchasedPlace) throws IOException;
    void increaseNumberOfFreeSeats(Integer carriageId,int returnedTicket) throws IOException;



}
