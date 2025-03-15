package tadjik.ilyosjon.kunuz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.model.Article;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

    boolean existsByTitle(String title);

    Optional<Article> findById(List<Article> uuid);

    void deleteById(UUID uuid);
}

