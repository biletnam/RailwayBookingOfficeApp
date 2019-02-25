import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RouteRepoImpl implements RouteRepo {
    private static final String PASSENGER_FILE_PATH = "/home/maya/IdeaProjects/railwaybookingoffice/" +
                                                        "src/main/resources/Routes.csv";

    public void save(Route route) throws IOException {
        File filewithRoutes = new File(PASSENGER_FILE_PATH);
        FileWriter fw = new FileWriter(filewithRoutes,true);
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            String RouteToSting = route.getId() + ","
                    +route.getDeparturePlace() + ","
                    +route.getArrivalPlace() + ","
                    +route.getDepartureTime() + ","
                    +route.getArrivalTime();
            bw.write(RouteToSting);
            bw.newLine();
        }

    }

    public List<Route> findAll() {
        return null;
    }

    public void update(Route route) {

    }

    public void delete(Integer id) throws IOException {
        File filewithRoutes = new File(PASSENGER_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(filewithRoutes);
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

            FileWriter fw = new FileWriter(filewithRoutes,false);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for(String str : list){
                    bw.write(str + "\n");
                }
            }
        }
    }

    public Route getById(Integer id) {
        return null;
    }
}
