import java.io.IOException;

public interface CarriageRepo extends GenericRepo<Carriage,Integer> {
    void decreaseNumberOfFreeSeats(Integer carriageId) throws IOException;
    void increaseNumberOfFreeSeats(Integer carriageId) throws IOException;
    int getNumbersOfFreeSeats(Integer carriageId) throws IOException;


}
