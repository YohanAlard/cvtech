package fr.yalard.cvtech.cvtech.model.sql;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private Instant dateOfBirth;
    private Address Address;
    private String email;
    private String phoneNumber;

    private Set<Resume> resumes = new HashSet<Resume>();
}
