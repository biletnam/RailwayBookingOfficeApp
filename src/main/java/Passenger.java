import java.util.ArrayList;
import java.util.List;

public class Passenger extends BaseEntity {
    private int id; // *--> it's for saving "id" in the moment of creating
    private String firstName;
    private String lastName;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Passenger(String firstName, String lastName) {
        this.id = super.getId(); // *--> it's for saving "id" in the moment of creating
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
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
