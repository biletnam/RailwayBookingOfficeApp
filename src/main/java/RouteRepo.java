import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface RouteRepo extends GenericRepo<Route,Integer> {
    List<Route> searchByDeparturePlace(String departurePlace) throws IOException;
    List<Route> searchByarrivalPlace(String arrivalPlace) throws IOException;
    List<Route> searchByDate(String date);
    List<Route> searchByAll(String departurePlace,String arrivalPlace,String date);




}
