package fr.belbaz.springtest.service;

import fr.belbaz.springtest.data.dto.RatedCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService
{
    List<RatedCategoryDTO> getAverageRatings(int year);
}
