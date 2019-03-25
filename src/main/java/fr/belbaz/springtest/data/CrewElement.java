package fr.belbaz.springtest.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "principals")
@Data
public class CrewElement
{
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tconst")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Title title;

    @ManyToOne
    @JoinColumn(name = "nconst")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person person;

    private String category;
    private String job;

    private int    ordering;
    private String characters;
}
