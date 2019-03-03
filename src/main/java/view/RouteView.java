package view;



import controller.RouteController;
import model.Route;

import java.io.IOException;
import java.util.Scanner;

public class RouteView {
    Scanner scanner = new Scanner(System.in);
    RouteController rc = new  RouteController();


    public void geRouteView() throws IOException {
        System.out.println("Enter:" + "\n" +
                "'add' for adding new route" + "\n" +
                "'delete' for deleting route" + "\n" +
                "show' for showing all the routes" + "\n" +
                "'menu' for return to menu" + "\n+" +
                "'exit' for exit");

        String input = scanner.nextLine();
        Route routeToSave = new Route();
        while (!input.equals("exit")) {

            switch (input) {
                case "add":
                    System.out.println("Enter id:");
                    routeToSave.setId(Integer.parseInt(scanner.next()));

                    System.out.println("Enter the departure's place: ");
                    routeToSave.setDeparturePlace(scanner.next());

                    System.out.println("Enter the arrival's place: ");
                    routeToSave.setArrivalPlace(scanner.next());

                    rc.save(routeToSave);

                    System.out.println("New route was successfully added!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "delete":
                    System.out.println("Enter id of deleting route:");
                    int idDeletingRoute= Integer.parseInt(scanner.next());
                    rc.delete(idDeletingRoute);
                    System.out.println("The route was successfully deleted!");
                    System.out.println("Do you want to continue work with this menu?");
                    input = scanner.next();
                    break;

                case "show":
                    System.out.println(rc.findAll());
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
