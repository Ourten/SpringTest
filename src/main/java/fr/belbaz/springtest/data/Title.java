package fr.belbaz.springtest.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "titles")
public class Title
{
    @Id
    private String tconst;

    @Column(length = 4096)
    private String primaryTitle;
    @Column(length = 4096)
    private String originalTitle;

    private String titleType;

    private boolean isAdult;

    private int startYear;
    private int endYear;

    private int runtimeMinutes;

    private String genres;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_tconst")
    private Set<Episode> episodes;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CrewElement> crewElements;

    private float averageRating;
    private int   numVotes;
}
