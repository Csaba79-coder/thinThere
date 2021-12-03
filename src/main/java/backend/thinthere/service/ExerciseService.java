package backend.thinthere.service;

import backend.thinthere.enums.Goal;
import backend.thinthere.enums.MuscleGroup;
import backend.thinthere.model.Exercise;
import backend.thinthere.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Optional<Exercise> getExerciseById(Long id) {
        return exerciseRepository.findById(id);
    }

    public Optional<Exercise> getExerciseByName(String name) {
        return exerciseRepository.findByName(name);
    }

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> getAllByMuscleGroup(MuscleGroup muscleGroup) {
        return exerciseRepository.findAllByMuscleGroup(muscleGroup);
    }

    public List<Exercise> getAllByGoal(Goal goal) {
        return exerciseRepository.findAllByGoal(goal);
    }

    /**
     * create, update, delete
     */

    public Exercise saveNewExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }
}
