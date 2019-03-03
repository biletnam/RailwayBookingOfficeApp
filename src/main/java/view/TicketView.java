package view;

import controller.*;
import model.Carriage;
import model.Passenger;
import model.Ticket;
import model.Train;
import repository.CarriageRepo;
import repository.CarriageRepoImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TicketView {
    Scanner scanner = new Scanner(System.in);

    PassengerController pc = new PassengerController();
    CarriageController cc = new CarriageController();
    RouteController rc = new RouteController();
    TrainController tc = new TrainController();
    TicketController ticketController = new TicketController();

    private static void  nicePrintForTrain(Train train){
        System.out.println("------------------");
        System.out.println("numberOfTrain: " + train.getId() + " | " + train.getRoute() + " | "
                +train.getDepartureTime() + "---" + train.getArrivalTime());
        for(Carriage carriage : train.getCarriages()){
            System.out.println("IdOfCarriage: " + carriage.getId() + " | "
                    + carriage.getCarriageType() +  " | "
                    +carriage.getNumberOfFreeSeats());
        }
    }

    public void getTicketView() throws IOException {
        System.out.println("Enter:" + "\n" +
                "'search' for searching a ticket according the several parameters" + "\n" +
                "'buy' for buying new ticket" + "\n" +
                "'return' for return your ticket" + "\n" +
                "'menu' for return to Admin menu" + "\n+" +
                "'exit' for exit");
        Ticket ticketToBuy = new Ticket();
        String input = scanner.nextLine();

        while (!input.equals("exit")) {
            switch (input) {
                case "search":
                    System.out.println("You can search a ticket by the next parametres:" +"\n"
                    + "a place of departure; a place of arrival; a date of departure.");
                    System.out.println("-------------------------------");
                    System.out.println("Enter a place of departure:");
                    String departurePlace = scanner.next();

                    System.out.println("Enter a place of arrival:");
                    String arrivalPlace = scanner.next();

                    System.out.println("Enter a date of departure in the next format: " +"\n"
                    + "yyyy,MM,dd");
                    String departureDateStr = scanner.next();
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy,MM,dd");
                    LocalDate departureDate = LocalDate.parse(departureDateStr, formatter2);
                    List<Train> trains = tc.generalSearch(departurePlace,arrivalPlace,departureDate);

                    for(Train train : trains){
                        nicePrintForTrain(train);
                    }
                    System.out.println("-------------------------------");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "buy":
                    System.out.println("----------------------------------");
                    System.out.println("Enter the number of train: ");
                    Train trainTemp = tc.getById(Integer.parseInt(scanner.next()));
                    nicePrintForTrain(trainTemp);
                    ticketToBuy.setNumberOfTrain(trainTemp.getId());
                    System.out.println("-------------------------------");
                    System.out.println("To see the free places,enter id of a carriage: ");
                    int carriageId = Integer.parseInt(scanner.next());
                    Carriage carriageTemp = cc.getById(carriageId);
                    System.out.println(carriageTemp);
                    ticketToBuy.setNumberOfCarriage(carriageTemp.getId());
                    System.out.println("-------------------------------");
                    System.out.println("Choose the place and enter its number: ");
                    int inputPlace = Integer.parseInt(scanner.next());
                    ticketToBuy.setPlace((inputPlace));

                    ticketToBuy.setPrice(carriageTemp.getPrice());

                    //---------------Passenger-------------------------------
                    Passenger passengerTemp = new Passenger();
                    System.out.println("Enter id of passenger:"); //TODO: check if not in the .csv ! vs case --> skip this step!
                    passengerTemp.setId(Integer.parseInt(scanner.next()));

                    System.out.println("Enter the first name:");
                    passengerTemp.setFirstName(scanner.next());

                    System.out.println("Enter the last name:");
                    passengerTemp.setLastName(scanner.next());
                    pc.save(passengerTemp);
                    ticketToBuy.setPassenger(passengerTemp);
                    //-------------------------------------------------------
                    int ticketToBuyId = passengerTemp.getId();
                    ticketToBuy.setId(ticketToBuyId);
                    ticketController.save(ticketToBuy);
                    System.out.println("The ticket was successfully bought!");
                    cc.decreaseNumberOfFreeSeats(carriageId,inputPlace); // change tne number of free seats.
                    System.out.println("-----------------------------");
                    System.out.println(ticketToBuy);
                    System.out.println("| Time of buying: " + LocalDateTime.now());
                    System.out.println("-------------------------------");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "return":
                    System.out.println("Enter id of your carriage: ");
                    int carriageIdTicketReturned = Integer.parseInt(scanner.next());
                    System.out.println("Enter id of ticket you want to return: ");
                    int idTicketReturned = Integer.parseInt(scanner.next());
                    ticketController.delete(idTicketReturned);
                    cc.increaseNumberOfFreeSeats(carriageIdTicketReturned,idTicketReturned);
                    System.out.println("Your ticket  was successfully returned!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;
                    case "menu":
                    ConsoleHelper ch = new ConsoleHelper();
                    ch.getMenu();
                    break;
                    default:
                    System.out.println("Please,make your choice!");
                    input = scanner.next();
            }
        }
        System.out.println("The time of stop application: " + LocalDateTime.now());
    }
}
