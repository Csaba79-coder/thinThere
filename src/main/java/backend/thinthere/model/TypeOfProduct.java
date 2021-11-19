package backend.thinthere.model;

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

    /*GLUTEN_FREE,
    LACTOSE_FREE,
    SUGAR_FREE,
    VEGAN,
    OTHER*/
}
