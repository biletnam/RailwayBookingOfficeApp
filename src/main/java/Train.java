import java.util.List;

public class Train extends  BaseEntity {
    private int numberOfCarriages;
    private  List<Carriage> carriages;

    public Train(int id, int numberOfCarriages, List<Carriage> carriages) {
        super(id);
        this.numberOfCarriages = numberOfCarriages;
        this.carriages = carriages;
    }

    public int getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public void setNumberOfCarriages(int numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
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
                " id=' " + super.getId() + '\'' +
                ", numberOfCarriages: " + numberOfCarriages +
                ", carriages: " + carriages +
                '}';
    }
}

