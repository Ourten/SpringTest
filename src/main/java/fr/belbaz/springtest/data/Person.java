package fr.belbaz.springtest.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
@Data
public class Person
{
    @Id
    private String nconst;

    private String primaryName;

    private int birthYear;
    private int deathYear;

    private String primaryProfession;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<CrewElement> crewElements;
}
