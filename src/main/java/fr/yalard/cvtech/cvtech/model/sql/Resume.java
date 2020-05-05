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
@Table(name = "resumes")
public class Resume extends AbstractEntity {
    String title;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Person person;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "resume_skills", joinColumns = @JoinColumn(name = "resume_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    Set<Skill> skills = new HashSet<Skill>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "resume_studies", joinColumns = @JoinColumn(name = "resume_id"), inverseJoinColumns = @JoinColumn(name = "study_id"))
    Set<Study> studies = new HashSet<Study>();
}
