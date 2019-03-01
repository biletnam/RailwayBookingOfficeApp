package repository;

import model.Carriage;
import model.Route;
import model.Train;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainRepoImpl implements TrainRepo {

    private static final String TRAIN_FILE_PATH = "/home/maya/IdeaProjects/railwaybookingoffice/" +
            "src/main/resources/trains.csv";

    @Override
    public void save(Train train) throws IOException {
        File fileWithTrains = new File(TRAIN_FILE_PATH);
        FileWriter fw = new FileWriter(fileWithTrains, true);

        //Getting model.Carriage's id and addint to list:
        List<Carriage> carriagesFromThisTrain = train.getCarriages();
        List<Integer> listWithCarriageId = new ArrayList<>();

        for (Carriage carriage : carriagesFromThisTrain) {
            listWithCarriageId.add(carriage.getId());
        }

        try (BufferedWriter bw = new BufferedWriter(fw)) {
            String trainToSting = train.getId() + ","
                    + train.getRoute().getId() + ","
                    + train.getDepartureTime() + ","
                    + train.getArrivalTime() + ","
                    + listWithCarriageId;
            bw.write(trainToSting);
            bw.newLine();
        }

    }

    @Override
    public List<Train> findAll() throws IOException {
        return null;
    }

    @Override
    public void delete(Integer id) throws IOException {
        File filewithTrains = new File(TRAIN_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(filewithTrains);
        String line;

        try (BufferedReader bf = new BufferedReader(fr)) {
            while ((line = bf.readLine()) != null) {

                String[] arrOfStr = line.split(",");
                if (arrOfStr[0].equals(Integer.toString(id))) {
                    continue;
                } else {
                    list.add(line);
                }
            }

            FileWriter fw = new FileWriter(filewithTrains, false);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (String str : list) {
                    bw.write(str + "\n");
                }
            }
        }

    }


    //----------------------------------Parsing method for the model.Carriage'd Ids----------------:
    private static List<Carriage> parseStringWithCarriageId(String line) throws IOException {

        String carriageId = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
        // 1)----- Parsing String from "10, 20,..." to  10,20...
        String[] carriageIdArray = carriageId.split(", ");
        List<String> carriageIdListString = new ArrayList<>(Arrays.asList(carriageIdArray));
        // 2)---- Converting List<String> to List<Integer>---------------:
        List<Integer> carriageIdListInteger = new ArrayList<>();
        for (String Id : carriageIdListString) {
            carriageIdListInteger.add(Integer.parseInt(Id));
        }
        // 3)---- getting instance of model.Carriage and adding to List------:
        List<Carriage> trainCarriages = new ArrayList<>();
        for (Integer integer : carriageIdListInteger) {
            CarriageRepo cr = new CarriageRepoImpl();
            Carriage carriage = cr.getById(integer);
            trainCarriages.add(carriage);
        }
        return trainCarriages;
    }
    //---------------------------------------------------------------------------------------;

    @Override
    public Train getById(Integer id) throws IOException {
        File fileWithTrains = new File(TRAIN_FILE_PATH);
        FileReader fr = new FileReader(fileWithTrains);
        String line;
        String departureStr;
        String arrivalStr;

        try (BufferedReader bf = new BufferedReader(fr)) {
            while ((line = bf.readLine()) != null) {
                String[] arrOfStr = line.split(",");
                if (arrOfStr[0].equals(Integer.toString(id))) {

                    Integer routeId = Integer.parseInt(arrOfStr[1]);
                    RouteRepo rr = new RouteRepoImpl();
                    Route route = rr.getById(routeId);
                    List<Carriage> trainCarriages = parseStringWithCarriageId(line); //TODO: USE Parsing method HERE!

                    //================LocalDateTime==============================:
                    departureStr = arrOfStr[2];
                    arrivalStr = arrOfStr[3];
                    LocalDateTime departureDateTime = LocalDateTime.parse(departureStr);
                    LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalStr);
                    //==============================================================;
                    return new Train(id, route,
                            departureDateTime, arrivalDateTime, trainCarriages);
                }
            }
        }
        return null;
    }

//    @Override
//    105,1,2019-03-01T10:00,2019-03-01T22:00,[1, 2, 3, 4, 5]
    /*id;
    private model.Route route;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private  List<model.Carriage> carriages*/;

    // https://ramj2ee.blogspot.com/2018/01/how-to-convert-localdatetime-to_37.html
    public List<Train> generalSearch(String departurePlace, String arrivalPlace, LocalDate departureDate)
            throws IOException {
        File fileWithTrains = new File(TRAIN_FILE_PATH);
        List<Train> listWithTrain = new ArrayList<>();
        FileReader fr = new FileReader(fileWithTrains);
        String line;
        LocalDateTime localDateTime;
        LocalDate localDate;


        try (BufferedReader bf = new BufferedReader(fr)) {
            while ((line = bf.readLine()) != null) {
                String[] arrOfStr = line.split(",");
                RouteRepo rr = new RouteRepoImpl();
                Integer RouteId = Integer.parseInt(arrOfStr[1]);
                Route route = rr.getById(RouteId);
                localDateTime = LocalDateTime.parse(arrOfStr[2]);
                localDate = localDateTime.toLocalDate();

                    if (route.getDeparturePlace().equals(departurePlace)
                            && route.getArrivalPlace().equals(arrivalPlace)
                            && (localDate).equals(departureDate)) {

                        List<Carriage> trainCarriages = parseStringWithCarriageId(line); //TODO: USE Parsing method HERE!
                        listWithTrain.add(new Train(Integer.parseInt(arrOfStr[0]), route,
                                LocalDateTime.parse(arrOfStr[2]), LocalDateTime.parse(arrOfStr[3]), trainCarriages));

                    }
                }
            }
            return listWithTrain;
        }
    }

