package view;

import controller.RouteController;
import controller.TrainController;
import model.Route;
import model.Train;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TrainView {
    Scanner scanner = new Scanner(System.in);
    TrainController tc = new TrainController();

    public void getTrainView() throws IOException {
        System.out.println("Enter:" + "\n" +
                "'add' for adding new train" + "\n" +
                "'delete' for deleting train" + "\n" +
                "show' for showing all the trains" + "\n" +
                "'menu' for return to menu" + "\n+" +
                "'exit' for exit");

        String input = scanner.nextLine();
        Train trainToSave = new Train();

        while (!input.equals("exit")) {

            switch (input) {
                case "add":
                    System.out.println("Enter id:");
                    trainToSave.setId(Integer.parseInt(scanner.next()));

                    //--------Set of route's logic-------------------------------------------------------
                    RouteController rc = new RouteController();
                    System.out.println("Choose your route from this list and enter its id:" +"\n"
                    +rc.findAll());
                    Route routeToSave = rc.getById(Integer.parseInt(scanner.next()));
                    trainToSave.setRoute(routeToSave);

                    //-----------'LocalDateTime convert into String' logic-------------------------------
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd,HH,mm");

                    System.out.println("Enter time of departure in the next format: 'yyyy,MM,dd,HH,mm' :");
                    LocalDateTime departureDateTimeToSave = LocalDateTime.parse(scanner.next(), formatter);
                    trainToSave.setDepartureTime(departureDateTimeToSave);

                    System.out.println("Enter time of departure in the next format: 'yyyy,MM,dd,HH,mm' :");
                    LocalDateTime arrivalDateTimeToSave = LocalDateTime.parse(scanner.next(), formatter);
                    trainToSave.setArrivalTime(arrivalDateTimeToSave);
                    //--------Set of carriage's logic----------------------------------------------------
                    //TODO:  String Id from user's input convert into List<Carriage> carriages
                    // parsing method from TrainRepoImpl !!!

                    //------------------------------------------------

                    tc.save(trainToSave);

                    System.out.println("New train was successfully added!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "delete":
                    System.out.println("Enter id of deleting train:");
                    int idDeletingTrain = Integer.parseInt(scanner.next());
                    tc.delete(idDeletingTrain);
                    System.out.println("The train was successfully deleted!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "show":
                    //TODO: generall search or findAll?
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "menu":
                    ConsoleHelper ch = new ConsoleHelper();
                    ch.getMenu();
                default:
                    System.out.println("Please,make your choice!");
                    input = scanner.next();
            }
        }
    }
}
