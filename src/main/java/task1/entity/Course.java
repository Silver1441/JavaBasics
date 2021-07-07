package task1.entity;

import lombok.Getter;

@Getter
public class Course {
    final private String name;
    final private int duration;

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
}
