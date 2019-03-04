package view;

import controller.CarriageController;
import controller.RouteController;
import controller.TrainController;
import model.Carriage;
import model.Route;
import model.Train;
import repository.CarriageRepo;
import repository.CarriageRepoImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrainView {
    Scanner scanner = new Scanner(System.in);
    TrainController tc = new TrainController();

    //----------------------------------Parsing method for the Carriage'd Ids----------------:
    private static List<Carriage> parseStringWithCarriageId(String line) throws IOException {

        // 1)----- Parsing String------------------------------------------:
        String[] carriageIdArray = line.split(",");
        List<String> carriageIdListString = new ArrayList<>(Arrays.asList(carriageIdArray));
        // 2)---- Converting List<String> to List<Integer>-----------------:
        List<Integer> carriageIdListInteger = new ArrayList<>();
        for (String Id : carriageIdListString) {
            carriageIdListInteger.add(Integer.parseInt(Id));
        }
        // 3)---- getting instance of Carriage and adding to List-----------:
        List<Carriage> trainCarriages = new ArrayList<>();
        for (Integer integer : carriageIdListInteger) {
            CarriageRepo cr = new CarriageRepoImpl();
            Carriage carriage = cr.getById(integer);
            trainCarriages.add(carriage);
        }
        return trainCarriages;
    }
    //---------------------------------------------------------------------------------------;

    public void getTrainView() throws IOException {
        System.out.println("Enter:" + "\n" +
                "'add' for adding new train" + "\n" +
                "'delete' for deleting train" + "\n" +
                "'menu' for return to main menu" + "\n+" +
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
                    System.out.println("Choose your route from this list and enter its id: ");
                    List<Route> routes = rc.findAll();
                    for(Route r : routes){
                        System.out.println(r);
                    }
                    Route routeToSave = rc.getById(Integer.parseInt(scanner.next()));
                    trainToSave.setRoute(routeToSave);

                    //-----------'LocalDateTime convert into String' logic-------------------------------
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd,HH,mm");

                    System.out.println("Enter time of the departure in the next format: 'yyyy,MM,dd,HH,mm' :");
                    LocalDateTime departureDateTimeToSave = LocalDateTime.parse(scanner.next(), formatter);
                    trainToSave.setDepartureTime(departureDateTimeToSave);

                    System.out.println("Enter time of the arrival in the next format: 'yyyy,MM,dd,HH,mm' :");
                    LocalDateTime arrivalDateTimeToSave = LocalDateTime.parse(scanner.next(), formatter);
                    trainToSave.setArrivalTime(arrivalDateTimeToSave);

                    //--------Set of carriage's logic----------------------------------------------------
                    CarriageController cc = new CarriageController();
                    List<Carriage> carriages = cc.findAll();
                    System.out.println("Choose some carriages from this list and enter its id: ");
                    System.out.println("-----------------------------------");
                    for(Carriage c: carriages){
                        System.out.println("Id: "+c.getId() +" | " + c.getCarriageType() + " | " +
                                "numbers of free seats:" + c.getNumberOfFreeSeats());
                    }
                    scanner.nextLine();
                    input = scanner.nextLine();
                    System.out.println("id of the added carriages : " + input);
                    List<Carriage> trainCarriagesToSave = parseStringWithCarriageId(input);
                    trainToSave.setCarriages(trainCarriagesToSave);

                    //---------------------------------------------------------

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

                case "menu":
                    ConsoleHelper ch = new ConsoleHelper();
                    ch.getMenu();
                default:
                    System.out.println("Please,make your choice!");
                    input = scanner.next();
            }
        }
        System.out.println("The time of stop application: " + LocalDateTime.now());
        System.exit(0);
    }
}
