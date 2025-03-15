package tadjik.ilyosjon.kunuz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.model.Article;
import tadjik.ilyosjon.kunuz1.model.ArticleLike;

import java.util.List;
import java.util.Optional;

public interface ArticleLikeRepo extends JpaRepository<ArticleLike, Integer> {
    boolean existsById(Integer id);

    boolean existsById(List<Article> articleId);

    Optional<ArticleLike> findById(List<Article> articleId);

}
