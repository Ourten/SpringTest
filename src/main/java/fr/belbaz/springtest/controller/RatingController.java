package fr.belbaz.springtest.controller;

import fr.belbaz.springtest.data.dto.RatedCategoryDTO;
import fr.belbaz.springtest.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ratings")
public class RatingController
{
    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService)
    {
        this.ratingService = ratingService;
    }

    @GetMapping("/averages/{year}")
    public List<RatedCategoryDTO> getAverageRatingForCategory(@PathVariable int year)
    {
        return ratingService.getAverageRatings(year);
    }
}
