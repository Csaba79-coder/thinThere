package backend.thinthere.model;

import backend.thinthere.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(unique = true, nullable = false, columnDefinition = "varchar255")
    private String email;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String firstName;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @CreationTimestamp
    Date registrationDate;

    @UpdateTimestamp
    Date lastUpdate;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String country;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String postalCode;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String city;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String address;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String houseNumber;

    @Column(nullable = false, columnDefinition = "varchar255")
    private String phoneNumber;

    private boolean enabled;

    private boolean locked;

    @Enumerated(EnumType.STRING)
    private Role role;

    private int loyaltyPoint;

    @OneToMany(mappedBy="user")
    private List<Product> favourite;

    @OneToMany(mappedBy="user")
    private List<Order> order;
}
