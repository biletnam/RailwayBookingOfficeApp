import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ZTestAppRunner {
    private static void  nicePrint(Train train){
        System.out.println("------------------");
        System.out.println("numberOfTrain: " + train.getId());
        for(Carriage carriage : train.getCarriages()){
            System.out.println("numberOfCarriage: " + carriage.getId() + " | "
                    + carriage.getCarriageType() +  " | "
                    +carriage.getNumberOfFreeSeats());
        }

    }
    public static void main(String[] args) throws IOException {
        PassengerRepo pr = new PassengerRepoImpl();
        Passenger passenger =new Passenger(10,"Michael","Sullivan");
        Passenger passenger2 =new Passenger(20,"John","Rooney");
        pr.save(passenger);
        pr.save(passenger2);
        /*System.out.println(pr.findAll());
        System.out.println(pr.getById(10));*/


//-------------------------Testing Carriage------------------------------------------------
        CarriageRepo carriageRepo = new CarriageRepoImpl();
        //---------------for 1st train--------------------------------
        //----by using setters------------------:
        Carriage carriage1 = new Carriage();
        carriage1.setId(1);
        carriage1.setCarriageType(CarriageType.BERTH);

//----by using constructor---------------------:
        Carriage carriage2 = new Carriage(2,CarriageType.BERTH);
        Carriage carriage3 = new Carriage(3,CarriageType.COMPARTMENT);
        Carriage carriage4 = new Carriage(4,CarriageType.COMPARTMENT);
        Carriage carriage5 = new Carriage(5,CarriageType.DELUXE);

        carriageRepo.save(carriage1);
        carriageRepo.save(carriage2);
        carriageRepo.save(carriage3);
        carriageRepo.save(carriage4);
        carriageRepo.save(carriage5);

        //---------------for 2nd train--------------------------------
        Carriage carriage10 = new Carriage(10,CarriageType.COMPARTMENT);
        Carriage carriage20 = new Carriage(20,CarriageType.COMPARTMENT);
        Carriage carriage30 = new Carriage(30,CarriageType.COMPARTMENT);
        Carriage carriage40 = new Carriage(40,CarriageType.COMPARTMENT);
        Carriage carriage50 = new Carriage(50,CarriageType.DELUXE);
        Carriage carriage60 = new Carriage(60,CarriageType.DELUXE);

        carriageRepo.save(carriage10);
        carriageRepo.save(carriage20);
        carriageRepo.save(carriage30);
        carriageRepo.save(carriage40);
        carriageRepo.save(carriage50);
        carriageRepo.save(carriage60);


        carriageRepo.decreaseNumberOfFreeSeats(4);

        System.out.println(carriageRepo.getNumbersOfFreeSeats(5));

//        carriageRepo.delete(2);
/*        System.out.println(carriageRepo.getById(2));
        System.out.println(carriageRepo.findAll());*/



/*
//--------------------------Testing Route--------------------------------------------------
        RouteRepo rr = new RouteRepoImpl();

        String departureStr = "2019,03,01,10,00";
        String arrivalStr = "2019,03,01,22,00";

        String departureStr2 = "2019,03,05,18,00";
        String arrivalStr2 = "2019,03,06,07,00";
        //converting str to LocalDAteTime for View!!!!------------------------------------
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd,HH,mm");
        //--------------------------------------------------------------------------------
        LocalDateTime departureDateTime = LocalDateTime.parse(departureStr, formatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalStr, formatter);

        LocalDateTime departureDateTime2 = LocalDateTime.parse(departureStr, formatter);
        LocalDateTime arrivalDateTime2 = LocalDateTime.parse(arrivalStr, formatter);
        //----------------------------------------------------------------------------------
        Route route =new Route(12,"Kiev","Odessa", departureDateTime,arrivalDateTime);
        Route route2 = new Route(15,"Kiev","Lviv",departureDateTime2,arrivalDateTime2);
        rr.save(route);
        rr.save(route2);
*/



/*//---------------------------Testing Ticket----------------------------------------------------

        TicketRepo ticketRepo = new TicketRepoImpl();
        Ticket ticket = new Ticket(1,carriage, passenger,route);
        ticketRepo.save(ticket);
        //by setter:
        Ticket ticket2 = new Ticket();
        ticket2.setId(2);
        ticket2.setCarriage(carriage2);
        ticket2.setPassenger(passenger2);
        ticket2.setRoute(route2);

        ticketRepo.save(ticket2);

        Ticket ticket3 = new Ticket(3,carriage,passenger,route2);
        ticketRepo.save(ticket3);
        System.out.println("FINDED:" + ticketRepo.findAll());
        System.out.println(ticketRepo.getById(3));
        ticketRepo.delete(3);*/

//-----------------Testing Train-------------------------
        TrainRepo tr = new TrainRepoImpl();
        List<Carriage> carriages = new ArrayList<>();
        carriages.add(carriage1);
        carriages.add(carriage2);
        carriages.add(carriage3);
        carriages.add(carriage4);
        carriages.add(carriage5);

        List<Carriage> carriages2 = new ArrayList<>();
        carriages2.add(carriage10);
        carriages2.add(carriage20);
        carriages2.add(carriage30);
        carriages2.add(carriage40);
        carriages2.add(carriage50);
        carriages2.add(carriage60);

        Train train1 = new Train(1,5,carriages);
        tr.save(train1);// TODO: check in controller: number == carriages
        Train train2 = new Train(10,5,carriages2);
        tr.save(train2);
        nicePrint(train1);
        nicePrint(train2);
        Train trainById = tr.getById(10);
        nicePrint(trainById);

















    }
}
