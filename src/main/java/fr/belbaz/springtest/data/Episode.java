package fr.belbaz.springtest.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "episodes")
@Data
public class Episode
{
    @Id
    private String tconst;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Title parent;

    private int seasonNumber;
    private int episodeNumber;
}
