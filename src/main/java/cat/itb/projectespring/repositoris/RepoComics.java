package cat.itb.projectespring.repositoris;

import cat.itb.projectespring.model.Comic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoComics extends CrudRepository<Comic, String> {
}
