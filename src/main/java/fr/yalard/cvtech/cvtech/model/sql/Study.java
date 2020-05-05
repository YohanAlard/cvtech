package fr.yalard.cvtech.cvtech.model.sql;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class Study {
    private String diploma;
    private String school;
    private Instant startYear;
    private Instant endYear;
}
