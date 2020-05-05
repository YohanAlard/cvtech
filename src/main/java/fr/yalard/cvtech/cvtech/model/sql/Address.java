package fr.yalard.cvtech.cvtech.model.sql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity {
    private String streetAddress;
    private String city;
    private String postalCode;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Person person;
}
