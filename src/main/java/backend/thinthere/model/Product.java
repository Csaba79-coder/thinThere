package backend.thinthere.model;

import backend.thinthere.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String productName;

    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy = "product")
    private Set<Order> order;

/*    @ManyToMany (fetch = FetchType.LAZY )
    @JoinTable(name = "product_user", joinColumns = @JoinColumn(name ="product_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> user;*/


    @ManyToMany
    @JoinTable(name = "product_typeOfProduct", joinColumns = @JoinColumn(name ="product_id"),
        inverseJoinColumns = @JoinColumn(name = "typeOfProduct_name"))
    private Set<TypeOfProduct> typeOfProductList;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String packaging;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private double unitPrice;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String description;

    private String imgUrl;
    private int inStock;
    private int purchasedPieces;
    private int rating;

    @UpdateTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date lastUpdate;

    public Product(Category category,
        Set<TypeOfProduct> typeOfProductList, String productName, String packaging,
        double unitPrice,
        String description, int inStock) {
        this.category = category;
        this.typeOfProductList = typeOfProductList;
        this.productName = productName;
        this.packaging = packaging;
        this.unitPrice = unitPrice;
        this.description = description;
        this.inStock = inStock;
    }
}
