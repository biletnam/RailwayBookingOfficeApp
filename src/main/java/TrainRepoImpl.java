import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainRepoImpl implements TrainRepo {

    private static final String TRAIN_FILE_PATH = "/home/maya/IdeaProjects/railwaybookingoffice/" +
            "src/main/resources/trains.csv";

    @Override
    public void save(Train train) throws IOException {
        File filewithTrains = new File(TRAIN_FILE_PATH);
        FileWriter fw = new FileWriter(filewithTrains, true);

        //Getting Carriage's id and addint to list:
        List<Carriage> carriagesFromThisTrain = train.getCarriages();
        List<Integer> listWithCarriageId = new ArrayList<>();
        for (Carriage carriage : carriagesFromThisTrain) {
            listWithCarriageId.add(carriage.getId());
        }

        try (BufferedWriter bw = new BufferedWriter(fw)) {
            String trainToSting = train.getId() + ","
                    + train.getNumberOfCarriages() + ","
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

    @Override
    public Train getById(Integer id) throws IOException {
        File filewithTrains = new File(TRAIN_FILE_PATH);
        FileReader fr = new FileReader(filewithTrains);
        String line;

        try (BufferedReader bf = new BufferedReader(fr)) {
            while ((line = bf.readLine()) != null) {
                String[] arrOfStr = line.split(",");
                if (arrOfStr[0].equals(Integer.toString(id))) {

                    int numberOfCarriages = Integer.parseInt(arrOfStr[1]);

                    String carriageId = line.substring(line.indexOf("[") + 1, line.indexOf("]"));

                    //=======Getting list of Carriage'sId=============================:

                    // 1)----- Parsing String from "10, 20, 30, 40, 50, 60" to  10,20...
//                    String delBrackets = carriageId.substring(1,carriageId.length() - 1);
                    String [] carriageIdArray  = carriageId.split(", ");
                    List <String> carriageIdListString = new ArrayList<>(Arrays.asList(carriageIdArray));


                    // 2)---- Converting Set<String> to Set<Integer>---------------:

                    List<Integer> carriageIdListInteger = new ArrayList<>();
                    for(String Id: carriageIdListString ) {
                        carriageIdListInteger.add(Integer.parseInt(Id));
                    }

                    // 3)---- getting instance of Carriage and adding to List------:
                        List<Carriage> trainCarriages = new ArrayList<>();
                      for(Integer integer : carriageIdListInteger){
                          CarriageRepo cr = new CarriageRepoImpl();
                          Carriage carriage = cr.getById(integer);
                          trainCarriages.add(carriage);
                      }
                    //=======-----------------------------=============================:
                      return new Train(id,
                            numberOfCarriages,
                            trainCarriages);
                }
            }
        }
        return null;
    }
}