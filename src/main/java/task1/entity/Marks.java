package task1.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Marks {
    final private int STUDENT_ID;
    final private int CURRICULUM_ID;
    @Setter
    private int numberOfMarks;
    @Setter
    private List<Integer> markList;

    public Marks(int studentId, int curriculumId) {
        this.STUDENT_ID = studentId;
        this.CURRICULUM_ID = curriculumId;
        markList = new ArrayList<>();
    }


}
