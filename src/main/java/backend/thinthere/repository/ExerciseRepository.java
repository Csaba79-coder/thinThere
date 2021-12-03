package backend.thinthere.repository;

import backend.thinthere.enums.Goal;
import backend.thinthere.enums.MuscleGroup;
import backend.thinthere.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findById(Long id);

    Optional<Exercise> findByName(String name);

    List<Exercise> findAll();

    List<Exercise> findAllByMuscleGroup(MuscleGroup muscleGroup);

    List<Exercise> findAllByGoal(Goal goal);
}
