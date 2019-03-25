package fr.belbaz.springtest.repository;

import fr.belbaz.springtest.data.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, String>
{
}
