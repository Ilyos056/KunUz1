package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.ArticleDto;
import tadjik.ilyosjon.kunuz1.model.Article;
import tadjik.ilyosjon.kunuz1.model.Category;
import tadjik.ilyosjon.kunuz1.model.Region;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.ArticleRepo;
import tadjik.ilyosjon.kunuz1.repository.CategoryRepo;
import tadjik.ilyosjon.kunuz1.repository.RegionRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    RegionRepo regionRepo;


    // get all
    public List<Article> findall() {
        return articleRepo.findAll();
    }

    // get by id
    public Article getbyid(UUID id){
        return articleRepo.findById(id).get();
    }

    // create
    public Result createarticle(ArticleDto articledto){
        boolean existsbytitle = articleRepo.existsByTitle(articledto.getTitle());
        if(existsbytitle){
            return new Result(false,"Title already exists");
        }
        Article article = new Article();
        article.setTitle(articledto.getTitle());
        article.setDescription(articledto.getDescription());
        article.setContent(articledto.getContent());
        article.setSharedcount(articledto.getShared_count());
        article.setImageid(articledto.getImage_id());

        Optional<Region> regionOptional = regionRepo.findById(articledto.getRegionsid());
        Region region = regionOptional.get();
        article.setRegionId((List<Region>)region);

        Optional<Category> categoryOptional = categoryRepo.findById(articledto.getCategoryid());
        Category category = categoryOptional.get();
        article.setCategoryId((List<Category>)category);

        articleRepo.save(article);
        return new Result(true,"Article created successfully");
    }

    // update
    public Result updatearticle(UUID uuid, ArticleDto articledto){
        Optional<Article> articleOptional =articleRepo.findById(uuid);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            article.setTitle(articledto.getTitle());
            article.setDescription(articledto.getDescription());
            article.setContent(articledto.getContent());
            article.setSharedcount(articledto.getShared_count());
            article.setImageid(articledto.getImage_id());

            Optional<Region> regionOptional = regionRepo.findById(articledto.getRegionsid());
            Region region = regionOptional.get();
            article.setRegionId((List<Region>)region);

            Optional<Category> categoryOptional = categoryRepo.findById(articledto.getCategoryid());
            Category category = categoryOptional.get();
            article.setCategoryId((List<Category>)category);

            articleRepo.save(article);
            return new Result(true,"Article updated successfully");
        }
        return new Result(false,"Article not found");
    }



    // delete
    public Result deletearticle(UUID uuid){
        articleRepo.deleteById(uuid);
        return new Result(true,"Article deleted successfully");
    }
}
