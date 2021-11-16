package backend.thinthere.model;

import backend.thinthere.enums.Category;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Product {

    @Id
    private Long id;
    private Category category;
    // private Type type;
    private String productName;
    private String packaging;
    private double unitPrice;
    private String description;
    private String imgUrl;
    private int inStock;
    private boolean isAvailable;
    private int purchased;
    private int rating;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date lastUpdate;
}
