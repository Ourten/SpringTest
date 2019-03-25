package fr.belbaz.springtest.service.impl;

import fr.belbaz.springtest.data.dto.RatedCategoryDTO;
import fr.belbaz.springtest.repository.TitleRepository;
import fr.belbaz.springtest.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService
{
    private TitleRepository titleRepository;

    @Autowired
    public RatingServiceImpl(TitleRepository titleRepository)
    {
        this.titleRepository = titleRepository;
    }

    @Override
    public List<RatedCategoryDTO> getAverageRatings(int year)
    {
        var categories = titleRepository.getCategories();

        return categories.stream().map(category ->
                new RatedCategoryDTO(category, titleRepository.getAverageForCategoryAndStartYear(category, year)))
                .collect(Collectors.toList());
    }
}
