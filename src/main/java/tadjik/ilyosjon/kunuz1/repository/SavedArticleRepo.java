package tadjik.ilyosjon.kunuz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.model.SavedArticle;

public interface SavedArticleRepo extends JpaRepository<SavedArticle, Integer> {

    boolean existsById(Integer id);
}
