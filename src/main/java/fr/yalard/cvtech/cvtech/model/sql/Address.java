package fr.yalard.cvtech.cvtech.model.sql;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity {
    private String streetAddress;
    private String city;
    private String postalCode;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Person person;
}
