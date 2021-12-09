package backend.thinthere.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class TypeOfProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "typeOfProductList")
    private List<Product> products = new ArrayList<>();

    public TypeOfProduct(String name) {
        this.name = name;
    }

    /*GLUTEN_FREE,
    LACTOSE_FREE,
    SUGAR_FREE,
    VEGAN,
    OTHER*/
}
