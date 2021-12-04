package backend.thinthere.controller;

import backend.thinthere.model.Exercise;
import backend.thinthere.service.ExerciseService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercises")
    public List<Exercise> getAllExercise() {
        return exerciseService.getAll();
    }

    @GetMapping("/exercises/{id}")
    public Optional<Exercise> getExerciseById(@PathVariable("id") Long id) {
        return exerciseService.getExerciseById(id);
    }

    @GetMapping("/exercises/name/{name}")
    public Optional<Exercise> getExerciseByName(@PathVariable("name") String name) {
        return exerciseService.getExerciseByName(name);
    }

    @PostMapping("/exercises")
    public Exercise addNewExercise(@RequestBody Exercise exercise) {
        Exercise newExercise =
                new Exercise(exercise.getId(),
                exercise.getName(),
                exercise.getStarterLevel(),
                exercise.getAdvancedLevel(),
                exercise.getMuscleGroup(),
                exercise.getGoal());
        return exerciseService.saveNewExercise(newExercise);
    }

    @PutMapping("/exercises/{id}")
    public Exercise updateExerciseById(@PathVariable("id") Long id, @RequestBody Exercise exercise) {
        Exercise exerciseData = exerciseService.getExerciseById(id).orElseThrow();

        try {
            exerciseData.setName(exercise.getName());
            exerciseData.setStarterLevel(exercise.getStarterLevel());
            exerciseData.setAdvancedLevel(exercise.getAdvancedLevel());
            exerciseData.setMuscleGroup(exercise.getMuscleGroup());
            exerciseData.setGoal(exercise.getGoal());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exerciseService.updateExercise(exerciseData);
    }

    public void deleteExercise(@PathVariable("id") Long id) {
        exerciseService.deleteExercise(id);
    }

}
