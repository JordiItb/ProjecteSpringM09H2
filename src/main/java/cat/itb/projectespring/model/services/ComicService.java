package cat.itb.projectespring.model.services;

import cat.itb.projectespring.model.Comic;
import cat.itb.projectespring.repositoris.RepoComics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ComicService {

    @Autowired
    private RepoComics repo;

    //private List<Comic> repo = new ArrayList<>();

    public void add(Comic e) {
        repo.save(e);
    }
    public List<Comic> comics() {
        return (List<Comic>) repo.findAll();
    }

    @PostConstruct
    public void init() {
        repo.saveAll(
                Arrays.asList(
                        new Comic("Pokemon", "Satoshi"),
                        new Comic("Batman", "Marvel")
                ));}


    public Comic searchByName(String s) {

        return repo.findById(s).orElse(null);

    }

    public void deleteComicByName(String s){

        repo.deleteById(s);

    }

    public void updateComic(Comic e, String nombre ){

        Comic c = repo.findById(nombre).orElse(null);

        c.setNomComic(e.getNomComic());
        c.setAutorComic(e.getAutorComic());

        repo.save(c);

    }
}
