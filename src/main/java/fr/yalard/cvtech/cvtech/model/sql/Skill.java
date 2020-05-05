package fr.yalard.cvtech.cvtech.model.sql;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "skills")
public class Skill extends AbstractEntity {
    private String name;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Level level;

    @ManyToMany(mappedBy = "skills")
    private Set<Resume> resumes = new HashSet<>();


}


