package fr.belbaz.springtest;

import fr.belbaz.springtest.data.Episode;
import fr.belbaz.springtest.data.Title;
import fr.belbaz.springtest.repository.TitleRepository;
import fr.belbaz.springtest.service.RatingService;
import fr.belbaz.springtest.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Set;

@SpringBootApplication
@EnableWebMvc
public class SpringTestApplication implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private TitleService titleService;

    @Autowired
    private RatingService ratingService;

    @Override
    public void run(String... arg0)
    {
        var title = new Title();
        title.setTconst("tt00001");
        title.setNumVotes(5);
        title.setAverageRating(1.8f);
        title.setPrimaryTitle("LALALA");
        title.setOriginalTitle("LALALA");
        title.setStartYear(1996);
        title.setTitleType("tvSeries");

        var episode = new Episode();
        episode.setTconst("ee000011");
        episode.setEpisodeNumber(1);
        episode.setSeasonNumber(1);

        var episode2 = new Episode();
        episode2.setTconst("ee000012");
        episode2.setEpisodeNumber(1);
        episode2.setSeasonNumber(1);

        title.setEpisodes(Set.of(episode, episode2));
        titleRepository.save(title);

        var title2 = new Title();
        title2.setTconst("tt00002");
        title2.setNumVotes(5);
        title2.setAverageRating(50f);
        title2.setStartYear(1996);
        title2.setPrimaryTitle("NOTHING");
        title2.setOriginalTitle("NOTHING");
        title2.setTitleType("tvSeries");
        titleRepository.save(title2);


        System.out.println(ratingService.getAverageRatings(1996));
    }
}
