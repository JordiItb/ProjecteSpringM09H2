package cat.itb.projectespring.repositoris;

import cat.itb.projectespring.model.Usuari;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsers extends CrudRepository<Usuari, String> {
}
