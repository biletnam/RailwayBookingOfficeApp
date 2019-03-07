package repository.io;

import model.Carriage;
import model.CarriageType;
import repository.CarriageRepo;


import java.io.*;
import java.util.*;

public class CarriageRepoImpl implements CarriageRepo {
    private static final String CARRIAGE_FILE_PATH = "/home/maya/IdeaProjects/railwaybookingoffice/" +
            "src/main/resources/carriage.csv";

    public void save(Carriage carriage) throws IOException {

        File filewithCarriages = new File(CARRIAGE_FILE_PATH);
        FileWriter fw = new FileWriter(filewithCarriages,true);
        try(BufferedWriter bw = new BufferedWriter(fw)){
            String carriageToSting = carriage.getId() +","
                    + carriage.getCarriageType() +","
                    +carriage.getNumberOfFreeSeats() +","
                    +carriage.getPrice() +","
                    + carriage.getFreeSeats();
            bw.write(carriageToSting);
            bw.newLine();
        }
    }

    public List<Carriage> findAll() throws IOException {

        File filewithCarriages = new File(CARRIAGE_FILE_PATH);
        FileReader fr = new FileReader(filewithCarriages);
        List<String> tempList = new ArrayList<>();
        List<Carriage> carriagesList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)){
            while((line = br.readLine()) != null){
                tempList.add(line);
            }

            for(String aTempList: tempList){
                String[] arrOfStr = aTempList.split(",");
                carriagesList.add(new Carriage(
                        Integer.parseInt(arrOfStr[0]),
                        CarriageType.getCarriageType(arrOfStr[1])));
            }
        }
        return carriagesList;
    }

    public void delete(Integer id) throws IOException {
        File filewithCarriages = new File(CARRIAGE_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(filewithCarriages);
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

            FileWriter fw = new FileWriter(filewithCarriages,false);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for(String str : list){
                    bw.write(str + "\n");
                }
            }
        }
    }

//----------------------------------Parsing method---------------------------------------:
    private static Set<Integer> parsePlaces(String line){
        String placesString = line.substring(line.indexOf("[") + 1, line.indexOf("]"));

        // 1)----- Parsing String from "1, 2, 3...," to  1,2...
        String [] placesArray  = placesString.split(", ");
        Set<String> placesArraySetString = new HashSet<>(Arrays.asList(placesArray));

        // 2)---- Converting Set<String> to Set<Integer>---------------:
        Set<Integer> placesArraySetInteger = new HashSet<>();
        for(String Id: placesArraySetString ) {
            placesArraySetInteger.add(Integer.parseInt(Id));
        }
        return placesArraySetInteger;
    }

//---------------------------------------------------------------------------------------;

    public Carriage getById(Integer id) throws IOException {
        File filewithCarriages = new File(CARRIAGE_FILE_PATH);
        FileReader fr = new FileReader(filewithCarriages);
        String line;

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(id))){
                    Set<Integer> placesSet = parsePlaces(line); //TODO: USE Parsing method HERE!
                    Carriage carriage = new Carriage(id,
                            CarriageType.getCarriageType(arrOfStr[1]));
                    carriage.setNumberOfFreeSeats(Integer.parseInt(arrOfStr[2]));
                    carriage.setFreeSeats(placesSet);

                    return carriage;
                }
            }
        }return null;
    }

    @Override
    public void decreaseNumberOfFreeSeats(Integer carriageId,int purchasedPlace) throws IOException {
        File fileWithCarriages = new File(CARRIAGE_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(fileWithCarriages);
        String line;
        int numberOfFreeSeats;

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(carriageId))){
                    numberOfFreeSeats = Integer.parseInt(arrOfStr[2]);
                    numberOfFreeSeats--;

                    Set<Integer> placesSet = parsePlaces(line); //TODO: USE Parsing method HERE!
                    placesSet.remove(purchasedPlace);

                String newLine = arrOfStr[0] + "," + arrOfStr[1] + "," + numberOfFreeSeats + ","
                        + arrOfStr[3] + "," + placesSet;
                list.add(newLine);
                }else {
                    list.add(line);
                }
            }
            FileWriter fw = new FileWriter(fileWithCarriages,false);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for(String str : list){
                    bw.write(str + "\n");
                }
            }
        }

    }

    @Override
    public void increaseNumberOfFreeSeats(Integer carriageId,int returnedTicket) throws IOException {
        File fileWithCarriages = new File(CARRIAGE_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(fileWithCarriages);
        String line;
        int numberOfFreeSeats;

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(carriageId))){
                    numberOfFreeSeats = Integer.parseInt(arrOfStr[2]);
                    numberOfFreeSeats++;

                    Set<Integer> placesSet = parsePlaces(line); //TODO: USE Parsing method HERE!
                    placesSet.add(returnedTicket);

                    String newLine = arrOfStr[0] + "," + arrOfStr[1] + "," + numberOfFreeSeats + ","
                            + arrOfStr[3] + "," + placesSet;
                    list.add(newLine);
                }else {
                    list.add(line);
                }
            }
            FileWriter fw = new FileWriter(fileWithCarriages,false);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for(String str : list){
                    bw.write(str + "\n");
                }
            }
        }
    }
}
