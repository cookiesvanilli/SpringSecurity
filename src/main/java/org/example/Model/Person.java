package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "persons")
@NamedNativeQuery(
        name = "findPersonByCity",
        query = "select * from persons p where p.cityOfLiving = :city"
)
public class Person {
    @EmbeddedId
    private Human human;
    @Column(length = 25, name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(length = 50, name = "cityOfLiving", nullable = false)
    private String cityOfLiving;


}