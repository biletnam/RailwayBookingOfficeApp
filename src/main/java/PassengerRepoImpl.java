import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepoImpl implements PassengerRepo {
    private static final String PASSENGER_FILE_PATH = "/home/maya/IdeaProjects/railwaybookingoffice/" +
                                                        "src/main/resources/Passenger.csv";


    public void save(Passenger passenger) throws IOException {
        File filewithPassengers = new File(PASSENGER_FILE_PATH);
        FileWriter fw = new FileWriter(filewithPassengers,true);
        try(BufferedWriter bw = new BufferedWriter(fw)){
            String passengerToSting = passenger.getId() +"," + passenger.getFirstName() + ","
                    + passenger.getLastName();
            bw.write(passengerToSting);
            bw.newLine();

        }

    }

    public List<Passenger> findAll() throws IOException {
        File filewithPassengers = new File(PASSENGER_FILE_PATH);
        FileReader fr = new FileReader(filewithPassengers);
        List<String> tempList = new ArrayList<>();
        List<Passenger> passengersList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)){
            while((line = br.readLine()) != null){
                tempList.add(line);
            }

            for(String aTempList: tempList){
                String[] arrOfStr = aTempList.split(",");
                Passenger tempPassenger = new Passenger(arrOfStr[1],arrOfStr[2]);
                tempPassenger.setId(Integer.parseInt(arrOfStr[0]));
                passengersList.add(tempPassenger);
            }

        }
        return passengersList;
    }

    public void update(Passenger passenger) {

    }

    public void delete(Integer integer) {

    }

    public Passenger getById(Integer integer) {
        return null;
    }
}
