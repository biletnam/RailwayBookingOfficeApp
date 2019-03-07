package repository.io;

import model.Route;
import repository.RouteRepo;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteRepoImpl implements RouteRepo {
    private static final String PASSENGER_FILE_PATH = "/home/maya/IdeaProjects/railwaybookingoffice/" +
                                                        "src/main/resources/routes.csv";

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

    public List<Route> findAll() throws IOException {
        File fileWithRoutes = new File(PASSENGER_FILE_PATH);
        FileReader fr = new FileReader(fileWithRoutes);
        List<String> tempList = new ArrayList<>();
        List<Route> routesList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)){
            while((line = br.readLine()) != null){
                tempList.add(line);
            }

            for(String aTempList: tempList){
                String[] arrOfStr = aTempList.split(",");
                int routeId = Integer.parseInt(arrOfStr[0]);
                Route route = new Route(routeId,arrOfStr[1], arrOfStr[2]);
                routesList.add(route);
            }
        }
        return routesList;
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




}
