package fr.belbaz.springtest.service;

import fr.belbaz.springtest.data.dto.CastEntryDTO;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TitleService
{
    List<CastEntryDTO> getCastingForTitle(String title);

    List<Pair<String, Long>> getLongestSeries(int amount);

    List<Pair<String, Long>> getShortestSeries(int amount);
}
