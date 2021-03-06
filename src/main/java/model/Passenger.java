package model;



public class Passenger extends BaseEntity {
    private String firstName;
    private String lastName;

    public Passenger() {
    }

    public Passenger(int id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Passenger Id: " + super.getId()  + "\n" + "Name: "  + firstName + " " + lastName + "\n";
    }
}
