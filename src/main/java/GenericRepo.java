import java.util.List;

public interface GenericRepo<T,ID> {
    void save(T t);
    List<T> findAll();
    void update(T t);
    void delete(ID id);
    T getById(ID id) ;

}
