package tadjik.ilyosjon.kunuz1.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.model.Article_Type;

public interface ArticleTypeRepo extends JpaRepository<Article_Type , Integer> {

    boolean existsById(Integer id);

}
