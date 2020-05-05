package fr.yalard.cvtech.cvtech.model.sql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


