import java.util.Set;

public class Carriage extends BaseEntity {
    private CarriageType carriageType;
    private  int numberOfFreeSeats;

    public Carriage() {

    }

    public Carriage(int id, CarriageType carriageType) {
        super(id);
        this.carriageType = carriageType;
        switch(carriageType) {
            case BERTH:
                numberOfFreeSeats = 54;
                break;
            case COMPARTMENT:
                numberOfFreeSeats = 36;
                break;
            case DELUXE:
                numberOfFreeSeats = 18;
                break;
        }
    }

    public CarriageType getCarriageType() {
        return carriageType;
    }

    public void setCarriageType(CarriageType carriageType) {
        this.carriageType = carriageType;
        switch(carriageType) {
            case BERTH:
                numberOfFreeSeats = 54;
                break;
            case COMPARTMENT:
                numberOfFreeSeats = 36;
                break;
            case DELUXE:
                numberOfFreeSeats = 18;
                break;
        }
    }

    public int getNumberOfFreeSeats() {
        return numberOfFreeSeats;
    }

    public void setNumberOfFreeSeats(int numberOfFreeSeats) {
        this.numberOfFreeSeats = numberOfFreeSeats;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "carriageType=" + carriageType +
                ", numberOfFreeSeats=" + numberOfFreeSeats +
                '}';
    }
}

