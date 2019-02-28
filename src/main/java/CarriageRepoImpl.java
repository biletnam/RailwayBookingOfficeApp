import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarriageRepoImpl implements CarriageRepo {
    private static final String CARRIAGE_FILE_PATH = "/home/maya/IdeaProjects/railwaybookingoffice/" +
            "src/main/resources/carriage.csv";

    public void save(Carriage carriage) throws IOException {

        File filewithCarriages = new File(CARRIAGE_FILE_PATH);
        FileWriter fw = new FileWriter(filewithCarriages,true);
        try(BufferedWriter bw = new BufferedWriter(fw)){
            String carriageToSting = carriage.getId() +","
                    + carriage.getCarriageType() +","
                    +carriage.getNumberOfFreeSeats();
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

    public Carriage getById(Integer id) throws IOException {
        File filewithCarriages = new File(CARRIAGE_FILE_PATH);
        FileReader fr = new FileReader(filewithCarriages);
        String line;

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(id))){
                    return new Carriage(id,
                            CarriageType.getCarriageType(arrOfStr[1]));
                }
            }
        }return null;
    }

    @Override
    public void decreaseNumberOfFreeSeats(Integer carriageId) throws IOException {
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
                String newLine = arrOfStr[0] + "," + arrOfStr[1] + "," + numberOfFreeSeats;
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
    public void increaseNumberOfFreeSeats(Integer carriageId) throws IOException {
        File fileWithCarriages = new File(CARRIAGE_FILE_PATH);
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(fileWithCarriages);
        String line;

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(carriageId))){
                    int numberOfFreeSeats = Integer.parseInt(arrOfStr[2]);
                    numberOfFreeSeats++;
                    String newLine = arrOfStr[0] + "," + arrOfStr[1] + "," + numberOfFreeSeats;
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
    public int getNumbersOfFreeSeats(Integer carriageId) throws IOException {

        File filewithCarriages = new File(CARRIAGE_FILE_PATH);
        FileReader fr = new FileReader(filewithCarriages);
        String line;

        try(BufferedReader bf = new BufferedReader(fr)){
            while((line = bf.readLine()) != null){
                String[] arrOfStr = line.split(",");
                if(arrOfStr[0].equals(Integer.toString(carriageId))){
                    return Integer.parseInt(arrOfStr[2]);
                }
            }
        }
        return 0;
    }
}
