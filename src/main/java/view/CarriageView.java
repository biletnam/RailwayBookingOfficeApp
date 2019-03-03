package view;

import controller.CarriageController;
import model.Carriage;
import model.CarriageType;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CarriageView {
    Scanner scanner = new Scanner(System.in);
    CarriageController cc = new CarriageController();

    public void getCarriageView() throws IOException {
        System.out.println("Enter:" + "\n" +
                "'add' for adding new Passenger" + "\n" +
                "'delete' for deleting passenger" + "\n" +
                "show' for showing all the passengers" + "\n" +
                "'menu' for return to menu" + "\n+" +
                "'exit' for exit");

        String input = scanner.nextLine();
        Carriage carriageToSave = new Carriage();
        while (!input.equals("exit")) {

            switch (input) {
                case "add":
                    System.out.println("Enter id:");
                    carriageToSave.setId(Integer.parseInt(scanner.next()));

                    System.out.println("Enter the type of carriage: " +"\n" + "BERTH/COMPARTMENT/DELUXE");
                    CarriageType carriageType = CarriageType.valueOf(scanner.next());
                    carriageToSave.setCarriageType(carriageType);
                    cc.save(carriageToSave);

                    System.out.println("New carriage was successfully added!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "delete":
                    System.out.println("Enter id of deleting carriage:");
                    int idDeletingCarriage= Integer.parseInt(scanner.next());
                    cc.delete(idDeletingCarriage);
                    System.out.println("The carriage was successfully deleted!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "show":
//                    System.out.println(cc.findAll());
                    List<Carriage> carriages = cc.findAll();

                    for(Carriage c: carriages){
                        System.out.println("Id: "+c.getId() +" | " + c.getCarriageType() + " | " +
                                "numbers of free seats:" + c.getNumberOfFreeSeats() + " | " +
                                "seats: " + c.getFreeSeats());
                    }
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
    }
}