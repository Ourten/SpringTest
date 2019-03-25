package fr.belbaz.springtest.controller;

import fr.belbaz.springtest.data.dto.CastEntryDTO;
import fr.belbaz.springtest.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/titles")
public class TitleController
{
    private TitleService titleService;

    @Autowired
    public TitleController(TitleService titleService)
    {
        this.titleService = titleService;
    }

    @GetMapping("/casting/{title}")
    public List<CastEntryDTO> getCastingForTitle(@PathVariable String title)
    {
        return titleService.getCastingForTitle(title);
    }

    @GetMapping("/tv/longest/{amount}")
    public List<Pair<String, Long>> getLongestSeries(@PathVariable int amount)
    {
        return titleService.getLongestSeries(amount);
    }

    @GetMapping("/tv/shortest/{amount}")
    public List<Pair<String, Long>> getShortestSeries(@PathVariable int amount)
    {
        return titleService.getShortestSeries(amount);
    }
}
