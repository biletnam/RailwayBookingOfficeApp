import java.io.IOException;

public class ZTestAppRunner {
    public static void main(String[] args) throws IOException {
        PassengerRepo pr = new PassengerRepoImpl();
        Passenger Passenger =new Passenger("Michael","Sullivan");
        Passenger Passenger2 =new Passenger("John","Rooney");
       /* Passenger Passenger3 =new Passenger("Maya","Kutsobina");
        Passenger Passenger4 =new Passenger("Maya1","Kutsobina1");*/
        pr.save(Passenger);
        pr.save(Passenger2);
        System.out.println(pr.findAll());










    }
}
