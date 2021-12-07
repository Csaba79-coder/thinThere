package backend.thinthere.controller;

import backend.thinthere.model.Exercise;
import backend.thinthere.service.ExerciseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ExerciseControllerTest {

    @Autowired
    private ExerciseService exerciseService;

    @Test
    void getAllExercise() throws Exception {
        List<Exercise> exerciseListExpected = new ArrayList<>();
        assertEquals(exerciseListExpected, exerciseService.getAll());
        assertEquals(0, exerciseListExpected.size());
    }
}
