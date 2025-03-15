package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.ArticleLikeDto;
import tadjik.ilyosjon.kunuz1.model.Article;
import tadjik.ilyosjon.kunuz1.model.ArticleLike;
import tadjik.ilyosjon.kunuz1.model.Profile;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.ArticleLikeRepo;
import tadjik.ilyosjon.kunuz1.repository.ArticleRepo;
import tadjik.ilyosjon.kunuz1.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleLikeService {
    @Autowired
    ArticleLikeRepo articleLikeRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ArticleRepo articleRepo;
    private Object List;

    // get all
    public List<ArticleLike> findByArticleall() {
        return articleLikeRepo.findAll();
    }

    // find by id
    public ArticleLike getbyid(Integer id){
        return articleLikeRepo.findById(id).get();
    }

    // create
    public Result createarticllike(ArticleLikeDto articleLikedto){
        boolean existsById = articleLikeRepo.existsById(articleLikedto.getArticleId());
        if(existsById){
            return new Result(false,"Title already exists");
        }
        ArticleLike articleLike = new ArticleLike();

        Optional<Profile> profileOptional = profileRepo.findById(articleLikedto.getProfileId());
        Profile profile = profileOptional.get();
        articleLike.setProfileId((List<Profile>)profile);

        Optional<Article> articleOptional = articleRepo.findById(articleLikedto.getArticleId());
        Article article = articleOptional.get();
        articleLike.setArticleId((List<Article>)article);

        articleRepo.save(article);
        return new Result(true, "saqlandi");
    }

    // update
    public Result updatearticlelike(Integer id, ArticleLikeDto articleLikedto, Object Article){
        boolean existsById = articleLikeRepo.existsById(id);
        if(existsById){
            Optional<ArticleLike> byId = articleLikeRepo.findById(articleLikedto.getArticleId());
            if (byId.isPresent()) {
                ArticleLike articleLike = byId.get();
                Optional<Profile> profileOptional = profileRepo.findById(articleLikedto.getProfileId());
                Profile profile = profileOptional.get();
                articleLike.setId((List<Profile>)profile);

                Optional<Article> articleOptional = articleRepo.findById(articleLikedto.getArticleId());
                Article article = articleOptional.get();
                articleLike.setArticleId((List<Article>article));
                articleLikeRepo.save(articleLike);

                return new Result(true, "saqlandi");
            }

        }
        return new Result(false, "saqlandi");
    }


    // delete
    public Result deletearticllike(Integer id){
        articleLikeRepo.deleteById(id);
        return new Result(true, "saqlandi");
    }
}
}
