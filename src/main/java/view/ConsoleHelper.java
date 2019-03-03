package view;

import java.io.IOException;
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


        System.out.println("Enter: 'P' - for Passenger, 'C' - for Carriage 'R' - for Route," +
                " 'T' - for Train, 'Ticket' - for Ticket.");
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

