import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketRepoImpl implements TicketRepo {
    private static final String Ticket_FILE_PATH = "/home/maya/IdeaProjects/" +
            "railwaybookingoffice/src/main/resources/tickets.csv";

    @Override  // buying in View
    public void save(Ticket ticket) throws IOException {
        File fileWithTickets = new File(Ticket_FILE_PATH);
        FileWriter fw = new FileWriter(fileWithTickets, true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {

            String ticketToSting = ticket.getId() + ","
                    + ticket.getCarriage().getId() + ","
                    + ticket.getPassenger().getId() + ","
                    + ticket.getRoute().getId() + ","
                    + ticket.getPlace() +  ","
                    + ticket.getBuyingTime();

            bw.write(ticketToSting);
            bw.newLine();
        }
    }

    @Override
    public List<Ticket> findAll() throws IOException {
        return null;
    }
    @Override // the return in View
    public void delete(Integer id) throws IOException {
        File fileWithTickets = new File(Ticket_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(fileWithTickets);
        String line;
//--------------------------------------------------------------------------------------------------
        TicketRepo ticketRepo = new TicketRepoImpl(); // change the number of the seats
        Ticket returnedTicket = ticketRepo.getById(id);
        System.out.println("before buying: free seats= " + returnedTicket.getPlace());
        /*returnedTicket.getCarriage().increaseNumberOfFreeSeats();
        System.out.println("before buying: free seats= " + returnedTicket.getPlace());*/
//--------------------------------------------------------------------------------------------------
        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(id))){
                    continue;
                }else {
                    list.add(line);
                }
            }

            FileWriter fw = new FileWriter(fileWithTickets,false);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for(String str : list){
                    bw.write(str + "\n");
                }
            }
        }
    }


    @Override
    public Ticket getById(Integer id) throws IOException {
        File fileWithTickets = new File(Ticket_FILE_PATH);
        FileReader fr = new FileReader(fileWithTickets);
        String line;

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(id))){

                    Ticket ticket = new Ticket();
                    Integer carriageId = Integer.parseInt(arrOfStr[1]);
                    CarriageRepo cr = new CarriageRepoImpl();
                    Carriage carriage = cr.getById(carriageId);

                    Integer passengerId = Integer.parseInt(arrOfStr[2]); //route
                    PassengerRepo pr = new PassengerRepoImpl();
                    Passenger passenger =  pr.getById(passengerId);

                    Integer routeId = Integer.parseInt(arrOfStr[3]);
                    RouteRepo rr = new RouteRepoImpl();
                    Route route = rr.getById(routeId);

                    int place = Integer.parseInt(arrOfStr[4]);
                    String buyingTimeStr = arrOfStr[5];

                    LocalDateTime buyingTime = LocalDateTime.parse(buyingTimeStr);

                    ticket.setId(id);
                    ticket.setCarriage(carriage);
                    ticket.setPassenger(passenger);
                    ticket.setRoute(route);
                    ticket.setPlace(place);
                    ticket.setBuyingTime(buyingTime);
                    return ticket;



                }
            }
        }
        return null;
    }


}
