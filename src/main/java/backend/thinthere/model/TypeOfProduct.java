package backend.thinthere.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

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
