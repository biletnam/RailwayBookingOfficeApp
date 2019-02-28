import java.io.File;
import java.io.IOException;
import java.util.List;

public interface GenericRepo<T,ID> {
    void save(T t) throws IOException;
    List<T> findAll() throws IOException;
    void delete(ID id) throws IOException;
    T getById(ID id) throws IOException;

}
