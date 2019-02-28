import java.io.IOException;
import java.util.List;

public class TrainController {
    TrainRepo tr = new TrainRepoImpl();
    public void save(Train train) throws IOException {
        tr.save(train);
    }
    public List<Train> findAll() throws IOException {
        return tr.findAll();
    }

    public void delete(Integer id) throws IOException {
        tr.delete(id);
    }

    public Train getById(Integer id) throws IOException {
        return tr.getById(id);
    }
}

