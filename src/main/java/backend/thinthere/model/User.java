package backend.thinthere.model;

import backend.thinthere.enums.Role;
import backend.thinthere.enums.UserAuthority;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(unique = true, nullable = false, columnDefinition = "varchar(255)")
    private String username;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String firstName;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @CreationTimestamp
    Date registrationDate;

    @UpdateTimestamp
    Date lastUpdate;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String country;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String postalCode;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String city;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String address;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String houseNumber;

    @Column(nullable = false, columnDefinition = "varchar(255)")
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (UserAuthority auth : role.AUTHS) {
            list.add(new SimpleGrantedAuthority(auth.toString()));
        }

        return list;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public User(String username, String firstName, String lastName, String password,
        String country, String postalCode, String city, String address, String houseNumber,
        String phoneNumber/*, Role role*/) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
        this.houseNumber = houseNumber;
        this.phoneNumber = phoneNumber;
        this.enabled = true;
        this.locked = false;
        this.role = Role.ADMIN;
    }

    public User(Long ID, String username, String firstName, String lastName, String password,
                String country, String postalCode, String city, String address, String houseNumber,
                String phoneNumber, List<Order> order) {
        this.ID = ID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
        this.houseNumber = houseNumber;
        this.phoneNumber = phoneNumber;
        this.enabled = true;
        this.locked = false;
        this.role = Role.USER;
        this.order = order;
    }

}
