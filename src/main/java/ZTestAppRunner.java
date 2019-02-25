import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ZTestAppRunner {
    public static void main(String[] args) throws IOException {
        PassengerRepo pr = new PassengerRepoImpl();
        Passenger Passenger =new Passenger(10,"Michael","Sullivan");
        Passenger Passenger2 =new Passenger(20,"John","Rooney");
        /*pr.save(Passenger);
        pr.save(Passenger2);
        System.out.println(pr.findAll());
        System.out.println(pr.getById(10));*/


//--------------------------Testing Route--------------------------------------------------
        RouteRepo rr = new RouteRepoImpl();

        String departureStr = "2019,03,01,10,00";
        String arrivalStr = "2019,03,01,22,00";
        //converting str to LocalDAteTime for View!!!!------------------------------------
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd,HH,mm");
        //--------------------------------------------------------------------------------
        LocalDateTime departureDateTime = LocalDateTime.parse(departureStr, formatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalStr, formatter);
        //----------------------------------------------------------------------------------
        Route route =new Route(12,"Kiev","Odessa",
                departureDateTime,arrivalDateTime);
        rr.save(route);
//        rr.delete(12);














    }
}
