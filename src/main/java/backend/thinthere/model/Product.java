package backend.thinthere.model;

import backend.thinthere.enums.Category;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

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

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String productName;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String packaging;

    @Column(nullable = false, columnDefinition = "varchar255")
    private double unitPrice;

    @Column(nullable = false, columnDefinition = "varchar255")
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
