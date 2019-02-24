import java.io.IOException;

public class ZTestAppRunner {
    public static void main(String[] args) throws IOException {
        PassengerRepo pr = new PassengerRepoImpl();
        Passenger Passenger =new Passenger(10,"Michael","Sullivan");
        Passenger Passenger2 =new Passenger(20,"John","Rooney");
        pr.save(Passenger);
        pr.save(Passenger2);
        System.out.println(pr.findAll());
        System.out.println(pr.getById(10));











    }
}
