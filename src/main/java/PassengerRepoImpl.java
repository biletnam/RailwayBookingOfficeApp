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
            String passengerToSting = passenger.getId() +","
                    + passenger.getFirstName() + ","
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
                passengersList.add(new Passenger(
                        Integer.parseInt(arrOfStr[0]),
                        arrOfStr[1],
                        arrOfStr[2]));
            }
        }
        return passengersList;
    }



    public void delete(Integer id) throws IOException {
        File filewithPassengers = new File(PASSENGER_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(filewithPassengers);
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

            FileWriter fw = new FileWriter(filewithPassengers,false);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for(String str : list){
                    bw.write(str + "\n");
                }
            }
        }
    }


    public Passenger getById(Integer id) throws IOException {
        File filewithPassengers = new File(PASSENGER_FILE_PATH);
        FileReader fr = new FileReader(filewithPassengers);
        String line;

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(id))){
                    return new Passenger(
                            id,
                            arrOfStr[1],
                            arrOfStr[2]);
                }
            }
        }return null;
    }
}
