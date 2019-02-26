import java.util.Date;

public class Ticket extends BaseEntity {
    private Carriage Carriage;
    private Passenger Passenger;
    private Route Route;
    private Date buyingTime;

    public Ticket (){

    }

    public Ticket(int id, Carriage carriage, Passenger passenger, Route route, Date buyingTime) {
        this.Carriage = Carriage;
        this.Passenger = Passenger;
        this.Route = Route;
        this.buyingTime = buyingTime;
    }

    public Carriage getCarriage() {
        return Carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.Carriage = Carriage;
    }

    public Passenger getPassenger() {
        return Passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.Passenger = Passenger;
    }

    public Route getRoute() {
        return Route;
    }

    public void setRoute(Route route) {
        this.Route = Route;
    }

    public Date getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(Date buyingTime) {
        this.buyingTime = buyingTime;
    }
}
