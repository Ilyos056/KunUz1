package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.SavedArticleDto;
import tadjik.ilyosjon.kunuz1.model.Article;
import tadjik.ilyosjon.kunuz1.model.Profile;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.model.SavedArticle;
import tadjik.ilyosjon.kunuz1.repository.ArticleRepo;
import tadjik.ilyosjon.kunuz1.repository.ProfileRepo;
import tadjik.ilyosjon.kunuz1.repository.SavedArticleRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SavedArticleService {

    @Autowired
    SavedArticleRepo savedArticleRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ArticleRepo articleRepo;

    // get all
    public List<SavedArticle> getallArticles(){
        return savedArticleRepo.findAll();
    }

    // get by id
    public SavedArticle getbyid(Integer id){
        return savedArticleRepo.findById(id).get();
    }

    // create
    public Result save(SavedArticleDto savedArticledto){
        SavedArticle savedArticle = new SavedArticle();

        Optional<Profile> profileOptional = profileRepo.findById(savedArticledto.getProfiles());
        Profile profile = profileOptional.get();
        savedArticle.setProfiles((List<Profile>)profile);

        Optional<Article> articleOptional = articleRepo.findById(savedArticledto.getArticles());
        Article article = articleOptional.get();
        savedArticle.setArticles((List<Article>)savedArticle);

        savedArticleRepo.save(savedArticle);
        return new Result(true,"success");
    }

    // update
    public Result updatesavedarticle(Integer id, SavedArticleDto savedArticledto){
        Optional<SavedArticle> savedArticleOptional = savedArticleRepo.findById(savedArticledto.getProfiles());
        if(savedArticleOptional.isPresent()){
            SavedArticle savedArticle = savedArticleOptional.get();

            Optional<Profile> profileOptional = profileRepo.findById(savedArticledto.getProfiles());
            Profile profile = profileOptional.get();
            savedArticle.setProfiles((List<Profile>)profile);

            Optional<Article> articleOptional = articleRepo.findById(savedArticledto.getArticles());
            Article article = articleOptional.get();
            savedArticle.setArticles((List<Article>)savedArticle);

            return  new Result(true,"success");
        }
        return new Result(false,"save article not found");
    }

    // delete
    public Result deletearticle(Integer id){
        savedArticleRepo.deleteById(id);
        return new Result(true,"success");
    }
}
