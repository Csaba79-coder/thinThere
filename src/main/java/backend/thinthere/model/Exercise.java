package backend.thinthere.model;

import backend.thinthere.enums.Goal;
import backend.thinthere.enums.MuscleGroup;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name="exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

    private int starterLevel;

    private int advancedLevel;

    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;

    @Enumerated(EnumType.STRING)
    private Goal goal;


    
}
