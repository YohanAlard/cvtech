package fr.yalard.cvtech.cvtech.model.sql;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "studies")
public class Study extends AbstractEntity {
    private String diploma;
    private String school;
    private Instant startYear;
    private Instant endYear;

    @ManyToMany(mappedBy = "studies")
    private Set<Resume> resumes = new HashSet<>();
}
