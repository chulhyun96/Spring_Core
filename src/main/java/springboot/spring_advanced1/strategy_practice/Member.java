package springboot.spring_advanced1.strategy_practice;

import lombok.Getter;
import lombok.Setter;

// DTO
@Getter @Setter
public class Member {
    private String name;
    private Grade grade;

    public Member(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }
}
