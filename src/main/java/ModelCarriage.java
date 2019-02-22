import java.util.Set;

public class ModelCarriage extends ModelBaseEntity {
    private ModelTypeCarriage modelTypeCarriage;
    private Set<Integer> numberOfSeats;

    public ModelCarriage(int id, ModelTypeCarriage modelTypeCarriage, Set<Integer> numberOfSeats) {
        super(id);
        this.modelTypeCarriage = modelTypeCarriage;
        this.numberOfSeats = numberOfSeats;
    }

    public ModelTypeCarriage getModelTypeCarriage() {
        return modelTypeCarriage;
    }

    public void setModelTypeCarriage(ModelTypeCarriage modelTypeCarriage) {
        this.modelTypeCarriage = modelTypeCarriage;
    }

    public Set<Integer> getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(Set<Integer> numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
