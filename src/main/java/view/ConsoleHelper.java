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



        System.out.println("RAILWAY BOOKING OFFICE - console crud application");
        System.out.println("-------------------------------");
        System.out.println("The application started running at " + LocalDateTime.now());
        System.out.println("-------------------------------");
        System.out.println("MAIN MENU");
        System.out.println("Enter: 'Admin' for getting admin access, 'Client' for buying a ticket, 'exit' for exit");
        System.out.println("-------------------------------");
        String menuChoosing = scanner.next();

        while (!menuChoosing.equals("exit")) {
            switch (menuChoosing) {
                case "Admin":
                    System.out.println("You are into admin's pannel");
                    System.out.println("Use the next command: ");
                    System.out.println("-------------------------------");
                    System.out.println("Enter: 'P' - for create|delete  passenger" + "\n" +
                            "'C' - for create|delete carriage" + "\n" +
                            "'R' - for create|delete route" + "\n" +
                            " 'T' - for create|delete Train" + "\n" +
                            "'Ticket' - for buy|return ticket.");

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
                            case "Ticket":
                                ticketView.getTicketView();
                                break;
                        case "exit":
                            System.exit(0);
                            break;
                            default:
                                System.out.println("Your choice is not right!");
                                userChoice = scanner.next();
                        }

                    break;

                case "Client":
                    System.out.println("Use the next command: ");
                    System.out.println("-------------------------------");
                    System.out.println("Enter: 'P' - for create|delete new account(passenger)" + "\n" +
                            "'Ticket' - for buy|return ticket.");
                    String userChoice2 = scanner.next();
                    switch (userChoice2) {
                        case "P":
                            passengerView.getPassengerView();
                            break;

                        case "Ticket":
                            ticketView.getTicketView();
                            break;
                        case "exit":
                            System.exit(0);
                        default:
                            System.out.println("Your choice is not right!");
                            userChoice2 = scanner.next();
                    }
                    break;
                default:
                    System.out.println("Try again!");
                    menuChoosing = scanner.next();
            }
        }
        System.out.println("The time of stop application: " + LocalDateTime.now());
    }
}

