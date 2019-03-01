package model;

import java.util.HashSet;
import java.util.Set;

public class Carriage extends BaseEntity {
    private CarriageType carriageType;
    private  int numberOfFreeSeats;
    private int price;
    private Set<Integer> freeSeats = new HashSet<>();

    //========================the methods for using into constructor===========

   private void createSeats(int number){
        for(int i = 1; i <= number; i++){
            freeSeats.add(i);
        }
    }
   //--------------------------------------------------------------------------
    private void fillCarriageData(CarriageType carriageType){
        switch(carriageType) {
            case BERTH:
                numberOfFreeSeats = 54;
                createSeats(numberOfFreeSeats);
                price = 100;
                break;
            case COMPARTMENT:
                numberOfFreeSeats = 36;
                createSeats(numberOfFreeSeats);
                price = 200;
                break;
            case DELUXE:
                numberOfFreeSeats = 18;
                createSeats(numberOfFreeSeats);
                price = 700;
                break;
        }
    }//========================================================================

    public Carriage() {
    }

    public Carriage(int id, CarriageType carriageType) {
        super(id);
        this.carriageType = carriageType;
        fillCarriageData(carriageType);
    }

    public CarriageType getCarriageType() {
        return carriageType;
    }

    public void setCarriageType(CarriageType carriageType) {
        this.carriageType = carriageType;
        fillCarriageData(carriageType);
    }


    public int getNumberOfFreeSeats() {
        return numberOfFreeSeats;
    }

    public Set<Integer> getFreeSeats() {
        return freeSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFreeSeats(Set<Integer> freeSeats) {
        this.freeSeats = freeSeats;
    }

    public void setNumberOfFreeSeats(int numberOfFreeSeats) {
        this.numberOfFreeSeats = numberOfFreeSeats;
    }


    @Override
    public String toString() {
        return "Carriage{" +
                "carriageType=" + carriageType +
                ", numberOfFreeSeats=" + numberOfFreeSeats +
                ", price=" + price +
                ", freeSeats=" + freeSeats +
                '}';
    }
}

