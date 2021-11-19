package backend.thinthere.model;

import backend.thinthere.enums.Category;
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

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<TypeOfProduct> typeOfProductList;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String productName;

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

    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date lastUpdate;
}
