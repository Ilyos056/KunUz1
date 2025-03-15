package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.SavedArticleDto;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.model.SavedArticle;
import tadjik.ilyosjon.kunuz1.repository.SavedArticleRepo;
import tadjik.ilyosjon.kunuz1.service.SavedArticleService;

import java.util.List;

@RestController
@RequestMapping("/savedarticle")
public class SavedArticleController {
    @Autowired
    SavedArticleService savedArticleService;
    @Autowired
    private SavedArticleRepo savedArticleRepo;

    @GetMapping
    public List<SavedArticle> getSavedArticles(){
        return savedArticleService.getallArticles();
    }

    @GetMapping("/{id}")
    public SavedArticle getbyid(@PathVariable Integer id){
        return savedArticleService.getbyid(id);
    }

    @PostMapping
    public Result save(@RequestBody SavedArticleDto savedArticledto){
        Result result = savedArticleService.save(savedArticledto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody SavedArticleDto savedArticledto){
        Result result = savedArticleService.updatesavedarticle(id, savedArticledto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        savedArticleRepo.deleteById(id);
        return new Result(true, "delete article successfully");
    }
}
