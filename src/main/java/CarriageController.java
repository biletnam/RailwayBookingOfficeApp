import java.io.IOException;
import java.util.List;

public class CarriageController {
   CarriageRepo carriageRepo = new CarriageRepoImpl();

    public void save(Carriage carriage) throws IOException{
        carriageRepo.save(carriage);
    }

    public List<Carriage> findAll() throws IOException{
        return  carriageRepo.findAll();
    }

    public void delete(Integer id) throws IOException{
        carriageRepo.delete(id);
    }

    public Carriage getById(Integer id) throws IOException {
         return carriageRepo.getById(id);
    }



}
