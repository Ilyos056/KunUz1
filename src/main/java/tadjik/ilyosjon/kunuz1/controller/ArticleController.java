package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.ArticleDto;
import tadjik.ilyosjon.kunuz1.model.Article;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.ArticleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.findall();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable UUID id){
        return articleService.getbyid(id);
    }

    @PostMapping
    public Result addArticle(@RequestBody ArticleDto articledto){
        Result result = articleService.createarticle(articledto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateArticle(@PathVariable UUID id, @RequestBody ArticleDto articledto){
        Result result = articleService.updatearticle(id, articledto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable UUID id){
        Result result = articleService.deletearticle(id);
        return result;
    }
}
