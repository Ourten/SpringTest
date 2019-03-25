package fr.belbaz.springtest.repository;

import fr.belbaz.springtest.data.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface TitleRepository extends JpaRepository<Title, String>
{
    Optional<Title> findByPrimaryTitle(String primaryTitle);

    @Query("SELECT AVG(e.averageRating) FROM Title e WHERE e.titleType=?1 AND e.startYear=?2")
    float getAverageForCategoryAndStartYear(String category, int startYear);

    @Query("SELECT DISTINCT e.titleType FROM Title e ")
    Collection<String> getCategories();
}
