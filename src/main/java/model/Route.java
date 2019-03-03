package model;



public class Route extends BaseEntity {
    private String departurePlace;
    private String arrivalPlace;

    public Route() {
    };

    public Route(int id, String departurePlace, String arrivalPlace) {
        super(id);
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
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

    @Override
    public String toString() {
        return "Route{" +
                "Id=" + super.getId() + " | "
                +departurePlace + '\'' +
                " <---> '" + arrivalPlace + '\'' +
                '}';
    }
}