package fr.yalard.cvtech.cvtech.model.sql;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
public class Resume {
    String title;
    Person person;
    Set<Skill> skills = new HashSet<Skill>();
    Set<Study> studies = new HashSet<Study>();
}
