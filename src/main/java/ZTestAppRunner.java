import model.*;
import repository.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ZTestAppRunner {

    private static void  nicePrintForTrain(Train train){
        System.out.println("------------------");
        System.out.println("numberOfTrain: " + train.getId() + " | " + train.getRoute() + " | "
                +train.getDepartureTime() + "---" + train.getArrivalTime());
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


//-------------------------Testing model.Carriage------------------------------------------------
        CarriageRepo carriageRepo = new CarriageRepoImpl();
        //---------------for 1st train--------------------------------
        //----by using setters------------------:
        Carriage carriage1 = new Carriage();
        carriage1.setId(1);
        carriage1.setCarriageType(CarriageType.BERTH);
        carriage1.setPrice(250);



        /*List<model.Carriage> c = carriageRepo.findAll();

        for( model.Carriage car: c){
            System.out.println(car.getCarriageType());
            System.out.println(car.getNumberOfFreeSeats());
            System.out.println(car.getFreeSeats());
        }*/



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

   /*     carriageRepo.decreaseNumberOfFreeSeats(4,1); //
        carriageRepo.decreaseNumberOfFreeSeats(4,2); //
        carriageRepo.decreaseNumberOfFreeSeats(4,3); //
        carriageRepo.decreaseNumberOfFreeSeats(4,27); //*/

        /*carriageRepo.increaseNumberOfFreeSeats(4,2);
        carriageRepo.increaseNumberOfFreeSeats(4,3);
        carriageRepo.increaseNumberOfFreeSeats(4,27);*/
//        System.out.println(carriageRepo.findAll()); // TODO: check after increase/decrease!! --> redo!
//        carriageRepo.delete(2);
        System.out.println(carriageRepo.getById(4)); // TODO: check after increase/decrease!!

        Carriage carriageTest = carriageRepo.getById(4);
        System.out.println(carriageTest.getFreeSeats());
        System.out.println(carriageTest.getNumberOfFreeSeats());


//        System.out.println(carriageRepo.getCurrentFreeSeats(4));

//--------------------------Testing model.Route--------------------------------------------------
        RouteRepo rr = new RouteRepoImpl();

      /*  String departureStr = "2019,03,01,10,00";
        String arrivalStr = "2019,03,01,22,00";

        String departureStr2 = "2019,03,05,18,00";
        String arrivalStr2 = "2019,03,06,07,00";
        //converting str to LocalDAteTime for View!!!!------------------------------------
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd,HH,mm");
        //--------------------------------------------------------------------------------
        LocalDateTime departureDateTime = LocalDateTime.parse(departureStr, formatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalStr, formatter);

        LocalDateTime departureDateTime2 = LocalDateTime.parse(departureStr2, formatter);
        LocalDateTime arrivalDateTime2 = LocalDateTime.parse(arrivalStr2, formatter);
        //----------------------------------------------------------------------------------*/
        Route route =new Route(1,"Kiev","Odessa");

        Route route2 = new Route(2,"Kiev","Lviv");


        rr.save(route);
        rr.save(route2);
        System.out.println(rr.getById(153));

//-----------------Testing model.Train-------------------------
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

        //++++++++++++++++++++=LocalDateTime=++++++++++++++++++++++++++++++++++++++++++++

        String departureStr = "2019,03,01,10,00";
        String arrivalStr = "2019,03,01,22,00";

        String departureStr2 = "2019,03,05,18,00";
        String arrivalStr2 = "2019,03,06,07,00";


        //converting str to LocalDAteTime for View!!!!------------------------------------
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd,HH,mm");

        //--------------------------------------------------------------------------------

        LocalDateTime departureDateTime = LocalDateTime.parse(departureStr, formatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalStr, formatter);

        LocalDateTime departureDateTime2 = LocalDateTime.parse(departureStr2, formatter);
        LocalDateTime arrivalDateTime2 = LocalDateTime.parse(arrivalStr2, formatter);
        //----------------LocalDate----------------------------------------------------------
        String departureDateStr = "2019,03,01";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy,MM,dd");
        LocalDate localDate = LocalDate.parse(departureDateStr, formatter2);
        //============================================================================

        Train train1 = new Train(105,route,departureDateTime,arrivalDateTime,carriages);
        tr.save(train1);
        Train train0 = new Train(155,route,departureDateTime,arrivalDateTime,carriages);
        tr.save(train0);


       Train train2 = new Train(91,route2,departureDateTime2,arrivalDateTime2,carriages2);
        tr.save(train2);
        nicePrintForTrain(train1);
        nicePrintForTrain(train2);
        Train trainById = tr.getById(105);
        nicePrintForTrain(trainById);
        ;
        List<Train> testGeneralSearsh = tr.generalSearch("Kiev",
                "Odessa",localDate);

        for(Train trainee: testGeneralSearsh){
            System.out.println("trainee: " + trainee.getId() + " | " + trainee.getRoute());

        }
        //---------------------------Testing model.Ticket----------------------------------------------------

Ticket ticket1 = new Ticket(1,passenger,105,4,26,200);
Ticket ticket2 = new Ticket(17,passenger,105,4,30,200);

TicketRepo ticketRepo = new TicketRepoImpl();
ticketRepo.save(ticket1);
ticketRepo.save(ticket2);
}
}
