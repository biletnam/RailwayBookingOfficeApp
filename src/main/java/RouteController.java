import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RouteController {

    RouteRepo routeRepo = new RouteRepoImpl();

    public void save(Route route) throws IOException {
        routeRepo.save(route);
    }

    public List<Route> findAll() throws IOException {
        return routeRepo.findAll();
    }

    public Route getById(Integer id) throws IOException {
        return routeRepo.getById(id);
    }


    public List<Route> searchByDeparturePlace(String departurePlace) throws IOException {
      return routeRepo.searchByDeparturePlace(departurePlace);
    }

    public List<Route> searchByarrivalPlace(String arrivalPlace) throws IOException {
        return routeRepo.searchByarrivalPlace(arrivalPlace);
    }

    public List<Route> searchByDate(String date) {
        return null;
    }


}
