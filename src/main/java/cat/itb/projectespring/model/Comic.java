package cat.itb.projectespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comic {
    @Id
    @NotNull
    @NotEmpty
    private String nomComic;
    private String autorComic;

    public String getNomComic() {
        return nomComic;
    }

    public void setNomComic(String nomComic) {
        this.nomComic = nomComic;
    }

    public String getAutorComic() {
        return autorComic;
    }

    public void setAutorComic(String autorComic) {
        this.autorComic = autorComic;
    }
}
