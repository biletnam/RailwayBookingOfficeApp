package repository.io;

import model.Passenger;
import model.Ticket;
import repository.PassengerRepo;
import repository.TicketRepo;
import repository.io.PassengerRepoImpl;

import java.io.*;
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
                    + ticket.getPassenger().getId() + ","
                    +ticket.getNumberOfTrain() + ","
                    +ticket.getNumberOfCarriage() + ","
                    +ticket.getPlace() + ","
                    +ticket.getPrice();
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
                    int passengerId = Integer.parseInt(arrOfStr[1]);
                    PassengerRepo pr = new PassengerRepoImpl();
                    Passenger passenger = pr.getById(passengerId);

                    return new Ticket(id,
                            passenger,
                            Integer.parseInt(arrOfStr[2]),
                            Integer.parseInt(arrOfStr[3]),
                            Integer.parseInt(arrOfStr[4]),
                            Integer.parseInt(arrOfStr[5])
                            );
                }
            }
        }return null;
    }

}
