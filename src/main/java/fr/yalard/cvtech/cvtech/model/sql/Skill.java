package fr.yalard.cvtech.cvtech.model.sql;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Skill {
    private String name;
    private String description;
    private Level level;


}
