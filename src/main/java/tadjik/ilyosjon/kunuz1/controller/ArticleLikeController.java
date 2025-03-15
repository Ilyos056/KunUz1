package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.ArticleLikeDto;
import tadjik.ilyosjon.kunuz1.model.ArticleLike;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.ArticleLikeService;

import java.util.List;

@RestController
@RequestMapping("/articlelike")
public class ArticleLikeController {
    @Autowired
    ArticleLikeService articleLikeService;

    @GetMapping
    public List<ArticleLike> getArticleLikeList(){
        return articleLikeService.findByArticleall();
    }


    @GetMapping("/{id}")
    public ArticleLike getArticleLikeById(@PathVariable Integer id){
        return articleLikeService.getbyid(id);
    }


    @PostMapping
    public Result addArticleLike(@RequestBody ArticleLikeDto articleLikedto){
        Result result = articleLikeService.createarticllike(articleLikedto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateArticleLike(@RequestBody ArticleLikeDto articleLikedto, @PathVariable Integer id){
        Result result = articleLikeService.updatearticlelike(id,articleLikedto, Article);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteArticleLike(@PathVariable Integer id){
        Result result = articleLikeService.deletearticllike(id);
        return result;
    }
}
