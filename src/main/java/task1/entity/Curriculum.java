package task1.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Curriculum {
    final private int ID;
    @Setter
    private String name;
    @Setter
    private LocalDate startDate;
    private List<Course> courses;

    public Curriculum(int ID, String name, List<Course> courses, LocalDate startDate) {
        this.ID = ID;
        this.name = name;
        this.courses = courses;
        this.startDate = startDate;
    }

}
