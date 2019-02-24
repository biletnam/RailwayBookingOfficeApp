import java.util.ArrayList;
import java.util.List;

public class BaseEntity {

    private static int id; // --> AutoId

    public BaseEntity() {
        id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

