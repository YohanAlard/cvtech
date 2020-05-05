package fr.yalard.cvtech.cvtech.model.sql;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    private String streetAddress;
    private String city;
    private String postalCode;
}
