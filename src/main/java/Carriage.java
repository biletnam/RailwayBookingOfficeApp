import java.util.Set;

public class Carriage extends BaseEntity {
    private CarriageType carriageType;
    private Set<Integer> numberOfSeats;

    public Carriage(CarriageType carriageType, Set<Integer> numberOfSeats) {
        this.carriageType = carriageType;
        this.numberOfSeats = numberOfSeats;
    }

    public CarriageType getCarriageType() {
        return carriageType;
    }

    public void setCarriageType(CarriageType carriageType) {
        this.carriageType = carriageType;
    }

    public Set<Integer> getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(Set<Integer> numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
