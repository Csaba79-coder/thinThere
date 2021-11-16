package backend.thinthere.model;

import javax.persistence.Id;
import java.io.Serializable;

public class User implements Serializable {

    @Id
    private String username;
}
