import java.time.LocalDate;
import java.time.LocalDateTime;

public class Route extends BaseEntity {
    private String departurePlace;
    private String arrivalPlace;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public Route(){

    };

    public Route(int id, String departurePlace, String arrivalPlace,
                 LocalDateTime departureTime, LocalDateTime arrivalTime) {
        super(id);
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
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

    @Override
    public String toString() {
        return "Route{" +
                departurePlace + '-' +
                arrivalPlace + ' ' +
                departureTime + "<-->"
                + arrivalTime +
                '}';
    }
}
