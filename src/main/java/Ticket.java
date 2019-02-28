import java.time.LocalDateTime;
import java.util.Date;

public class Ticket extends BaseEntity {
    private Carriage Carriage;
    private Passenger Passenger;
    private Route Route;
    private LocalDateTime buyingTime;
    private int place;

    public Ticket (){
        buyingTime = LocalDateTime.now();
    }

    public Ticket(int id, Carriage carriage, Passenger passenger, Route route) {
        super(id);
        Carriage = carriage;
        Passenger = passenger;
        Route = route;
        buyingTime = LocalDateTime.now();
        place = 0;
    }

    public Carriage getCarriage() {
        return Carriage;
    }

    public void setCarriage(Carriage carriage) {
        Carriage = carriage;
    }

    public Passenger getPassenger() {
        return Passenger;
    }

    public void setPassenger(Passenger passenger) {
        Passenger = passenger;
    }

    public Route getRoute() {
        return Route;
    }

    public void setRoute(Route route) {
        Route = route;
    }

    public LocalDateTime getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(LocalDateTime buyingTime) {
        this.buyingTime = buyingTime;
    }

    public int getPlace() {
        return Carriage.getNumberOfFreeSeats();
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Carriage=" + Carriage +
                ", PassengerId"+ Passenger +
                ", RouteId" + Route +
                ", buyingTime=" + buyingTime +
                ", place=" + place +
                '}';
    }
}
