package view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleHelper {
    Scanner scanner = new Scanner(System.in);
    PassengerView passengerView = new PassengerView();
    CarriageView carriageView = new CarriageView();
    RouteView routeView = new RouteView();
    TrainView trainView = new TrainView();
    TicketView ticketView = new TicketView();


    public void start() throws IOException {
        getMenu();
    }

    public void getMenu() throws IOException {

// TODO : split into: admin menu(Carriage, Route,Train; user menu(Passenger, Ticket).

        System.out.println("RAILWAY BOOKING OFFICE - console crud application");
        System.out.println("-------------------------------");
        System.out.println("Time of run: " + LocalDateTime.now());
        System.out.println("-------------------------------");
        System.out.println("Use the next command: ");
        System.out.println("-------------------------------");
        System.out.println("Enter: 'P' - for create|delete  passenger" +"\n" +
                                "'C' - for create|delete carriage" +"\n" +
                                "'R' - for create|delete route"  +"\n" +
                                " 'T' - for create|delete Train"+"\n" +
                                "'Ticket' - for buy|return ticket.");
        System.out.println("-------------------------------");
        String userChoice = scanner.next();
        switch (userChoice) {
            case "P":
                passengerView.getPassengerView();
                break;
            case "C":
                carriageView.getCarriageView();
                break;
            case "R":
                routeView.geRouteView();
                break;
            case "T":
                trainView.getTrainView();
            case"Ticket":
                ticketView.getTicketView();
                break;
            default:
                System.out.println("Your choice is not right!");

        }
    }


}

