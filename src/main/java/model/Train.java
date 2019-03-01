package model;

import java.time.LocalDateTime;
import java.util.List;

public class Train extends BaseEntity {

    private Route route;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private  List<Carriage> carriages;

    public Train(){ }

    public Train(int id, Route route, LocalDateTime departureTime, LocalDateTime arrivalTime, List<Carriage> carriages) {
        super(id);
        this.route = route;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.carriages = carriages;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    @Override
    public String toString() {
        return "Train{" +
                "route=" + route +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", carriages=" + carriages +
                '}';
    }
}

