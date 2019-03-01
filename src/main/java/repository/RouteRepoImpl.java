package repository;

import model.Route;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RouteRepoImpl implements RouteRepo {
    private static final String PASSENGER_FILE_PATH = "/home/maya/IdeaProjects/railwaybookingoffice/" +
                                                        "src/main/resources/Routes.csv";

    public void save(Route route) throws IOException {
        File fileWithRoutes = new File(PASSENGER_FILE_PATH);
        FileWriter fw = new FileWriter(fileWithRoutes,true);
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            String RouteToSting = route.getId() + ","
                    +route.getDeparturePlace() + ","
                    +route.getArrivalPlace() + ",";
            bw.write(RouteToSting);
            bw.newLine();
        }
    }

    public List<Route> findAll() {
        return null;
    }

    public void delete(Integer id) throws IOException {
        File fileWithRoutes = new File(PASSENGER_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(fileWithRoutes);
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

            FileWriter fw = new FileWriter(fileWithRoutes,false);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for(String str : list){
                    bw.write(str + "\n");
                }
            }
        }
    }

    public Route getById(Integer id) throws IOException {
        File fileWithRoutes = new File(PASSENGER_FILE_PATH);
        FileReader fr = new FileReader(fileWithRoutes);
        String line;
        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(id))){
                    return new Route(
                            id,
                            arrOfStr[1],
                            arrOfStr[2]);
                }
            }
        }return null;
    }




 /*   @Override
    public List<model.Route> searchByDeparturePlace(String departurePlace) throws IOException {
        File fileWithRoutes = new File(PASSENGER_FILE_PATH);
        FileReader fr = new FileReader(fileWithRoutes);
        String line;
        String departureStr;
        String arrivalStr;
        List<model.Route> departurePlaceList = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[1].equals(departurePlace)){
                    departureStr = arrOfStr[3];
                    arrivalStr = arrOfStr[4];
                    LocalDateTime departureDateTime = LocalDateTime.parse(departureStr);
                    LocalDateTime arrivalDateTime =  LocalDateTime.parse(arrivalStr);


                    departurePlaceList.add(new model.Route(
                            Integer.parseInt(arrOfStr[0]),
                            arrOfStr[1],
                            arrOfStr[2],
                            departureDateTime,
                            arrivalDateTime));
                }
            }
        }return departurePlaceList;

    }

    @Override
    public List<model.Route> searchByarrivalPlace(String arrivalPlace) throws IOException {
        File fileWithRoutes = new File(PASSENGER_FILE_PATH);
        FileReader fr = new FileReader(fileWithRoutes);
        String line;
        String departureStr;
        String arrivalStr;
        List<model.Route> arrivalPlaceList = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[2].equals(arrivalPlace)){
                    departureStr = arrOfStr[3];
                    arrivalStr = arrOfStr[4];
                    LocalDateTime departureDateTime = LocalDateTime.parse(departureStr);
                    LocalDateTime arrivalDateTime =  LocalDateTime.parse(arrivalStr);


                    arrivalPlaceList.add(new model.Route(
                            Integer.parseInt(arrOfStr[0]),
                            arrOfStr[1],
                            arrOfStr[2],
                            departureDateTime,
                            arrivalDateTime));
                }
            }
        }return arrivalPlaceList;
    }*/

   /* @Override
    public List<model.Route> searchByDate(String date) {
        return null;
    }*/

   /* @Override
    public List<model.Route> searchByAll(String departurePlace, String arrivalPlace, String date) {
        
        return null;
    }*/
}
