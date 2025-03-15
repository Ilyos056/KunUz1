package tadjik.ilyosjon.kunuz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.kunuz1.model.CommentLike;

public interface CommentLikeRepo extends JpaRepository<CommentLike, Integer> {

    boolean existsById(Integer id);

}
