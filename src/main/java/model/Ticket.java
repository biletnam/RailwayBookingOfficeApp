package model;



public class Ticket extends BaseEntity {
    private Passenger Passenger;
    private int numberOfTrain;
    private int numberOfCarriage;
    private int place;
    private int price;

    public Ticket(){
    }

    public Ticket(int id, Passenger passenger, int numberOfTrain,
                  int numberOfCarriage, int place, int price) {
        super(id);
        Passenger = passenger;
        this.numberOfTrain = numberOfTrain;
        this.numberOfCarriage = numberOfCarriage;
        this.place = place;
        this.price = price;
    }

    public Passenger getPassenger() {
        return Passenger;
    }

    public void setPassenger(Passenger passenger) {
        Passenger = passenger;
    }

    public int getNumberOfTrain() {
        return numberOfTrain;
    }

    public void setNumberOfTrain(int numberOfTrain) {
        this.numberOfTrain = numberOfTrain;
    }

    public int getNumberOfCarriage() {
        return numberOfCarriage;
    }

    public void setNumberOfCarriage(int numberOfCarriage) {
        this.numberOfCarriage = numberOfCarriage;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket Id: " + super.getId() + "\n" + Passenger +
                "| numberOfTrain: " + numberOfTrain +
                " | numberOfCarriage: " + numberOfCarriage +
                " | place: " + place +
                " | price: " + price + " | ";
    }
}

