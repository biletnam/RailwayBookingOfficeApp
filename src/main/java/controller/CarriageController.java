package controller;

import model.Carriage;
import repository.CarriageRepo;
import repository.CarriageRepoImpl;

import java.io.IOException;
import java.util.List;

public class CarriageController {
   CarriageRepo carriageRepo = new CarriageRepoImpl();

    public void save(Carriage carriage) throws IOException{
        if(carriage == null){
            throw  new IllegalArgumentException();
        }else carriageRepo.save(carriage);
    }

    public List<Carriage> findAll() throws IOException{
        return  carriageRepo.findAll();
    }

    public void delete(Integer id) throws IOException{
        if(id == null || id < 0) {
            throw new IllegalArgumentException();
        }else carriageRepo.delete(id);
    }

    public Carriage getById(Integer id) throws IOException {
        if(id == null || id < 0) {
            throw new IllegalArgumentException();
        }else return carriageRepo.getById(id);
    }

    public void decreaseNumberOfFreeSeats(Integer carriageId,int purchasedPlace) throws IOException{
        if((carriageId == null || carriageId < 0) &&
                (purchasedPlace  == 0 || purchasedPlace < 0)) {
            throw new IllegalArgumentException();
        }else carriageRepo.decreaseNumberOfFreeSeats(carriageId,purchasedPlace);
    };
    public void increaseNumberOfFreeSeats(Integer carriageId,int returnedTicket) throws IOException{
        if((carriageId == null || carriageId < 0) &&
                (returnedTicket  == 0 || returnedTicket < 0)) {
            throw new IllegalArgumentException();
        }else carriageRepo.increaseNumberOfFreeSeats(carriageId,returnedTicket);
    };



}
