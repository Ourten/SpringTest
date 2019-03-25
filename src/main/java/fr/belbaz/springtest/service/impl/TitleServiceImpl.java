package fr.belbaz.springtest.service.impl;

import fr.belbaz.springtest.data.Title;
import fr.belbaz.springtest.data.dto.CastEntryDTO;
import fr.belbaz.springtest.repository.TitleRepository;
import fr.belbaz.springtest.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.JoinType;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleServiceImpl implements TitleService
{
    private TitleRepository titleRepository;
    private EntityManager   entityManager;

    @Autowired
    public TitleServiceImpl(TitleRepository titleRepository, EntityManager entityManager)
    {
        this.titleRepository = titleRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<CastEntryDTO> getCastingForTitle(String title)
    {
        var foundTitle = this.titleRepository.findById(title)
                .orElse(this.titleRepository.findByPrimaryTitle(title).orElse(null));

        if (foundTitle == null)
            return Collections.emptyList();

        return foundTitle.getCrewElements().stream()
                .map(crew -> new CastEntryDTO(crew.getPerson().getPrimaryName(), crew.getJob()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pair<String, Long>> getLongestSeries(int amount)
    {
        var cb = entityManager.getCriteriaBuilder();

        var cq = cb.createTupleQuery();
        var title = cq.from(Title.class);
        var episodes = title.join("episodes", JoinType.LEFT);

        cq.select(cb.tuple(title, cb.count(episodes)));
        cq.where(cb.equal(title.get("titleType"), "tvSeries"));
        cq.groupBy(title.get("tconst"));
        cq.orderBy(cb.desc(cb.count(episodes)));

        var result = entityManager.createQuery(cq).setMaxResults(amount).getResultList();

        return result.stream()
                .map(tuple -> Pair.of(((Title) tuple.get(0)).getPrimaryTitle(), ((Long) tuple.get(1))))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pair<String, Long>> getShortestSeries(int amount)
    {
        var cb = entityManager.getCriteriaBuilder();

        var cq = cb.createTupleQuery();
        var title = cq.from(Title.class);
        var episodes = title.join("episodes", JoinType.LEFT);

        cq.select(cb.tuple(title, cb.count(episodes)));
        cq.where(cb.equal(title.get("titleType"), "tvSeries"));
        cq.groupBy(title.get("tconst"));
        cq.orderBy(cb.asc(cb.count(episodes)));

        var result = entityManager.createQuery(cq).setMaxResults(amount).getResultList();

        return result.stream()
                .map(tuple -> Pair.of(((Title) tuple.get(0)).getPrimaryTitle(), ((Long) tuple.get(1))))
                .collect(Collectors.toList());
    }
}
