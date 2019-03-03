package view;

import controller.PassengerController;
import model.Passenger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PassengerView {
    Scanner scanner = new Scanner(System.in);
    PassengerController pc = new PassengerController();



    public void getPassengerView() throws IOException {
        System.out.println("Enter:" +"\n" +
                "'add' for adding new Passenger" +"\n" +
                "'delete' for deleting passenger" +"\n" +
                "show' for showing all the passengers"  +"\n" +
                "'menu' for return to Admin menu" +"\n+" +
                "'exit' for exit");

        String input  = scanner.nextLine();
        Passenger passengerToSave = new Passenger();
        while(!input.equals("exit")){

            switch(input){
                case "add":
                    System.out.println("Enter id:");
                    input = scanner.next();
                    passengerToSave.setId(Integer.parseInt(input));

                    System.out.println("Enter the first name:");
                    input = scanner.next();
                    passengerToSave.setFirstName(input);

                    System.out.println("Enter the last name:");
                    input = scanner.next();
                    passengerToSave.setLastName(input);
                    pc.save(passengerToSave);

                    System.out.println("New passenger was successfully added!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "delete":
                    System.out.println("Enter id of deleting account:");
                    input = scanner.next();
                    int idDeletingPassenger= Integer.parseInt(input);
                    pc.delete(idDeletingPassenger);
                    System.out.println("The passenger was successfully deleted!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "show":
                    System.out.println(pc.findAll());
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
