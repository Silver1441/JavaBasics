package task1.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Student {
    final private int ID;
    @Setter
    private String name;
    @Setter
    private String surname;
    @Setter
    private int enrolledCurriculumId;
    @Setter
    private Marks marks;

    public Student(int ID) {
        this.ID = ID;
    }
}
