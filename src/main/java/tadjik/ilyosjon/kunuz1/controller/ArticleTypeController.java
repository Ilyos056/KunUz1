package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.ArticleTypeDto;
import tadjik.ilyosjon.kunuz1.model.Article_Type;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.ArticleTypeService;

import java.util.List;

@RestController
@RequestMapping("/Articletype")
public class ArticleTypeController {
    @Autowired
    ArticleTypeService articleTypeService;

    @GetMapping
    public List<Article_Type> getAll(){
        List<Article_Type> list = articleTypeService.getAll();
        return list;
    }

    @GetMapping("/{id}")
    public Article_Type getByid(@PathVariable Integer id) {
        Article_Type byid = articleTypeService.getById(id);
        return byid;
    }


    @PostMapping
    public Result create(@RequestBody ArticleTypeDto articleTypeDto) {
        Result result = articleTypeService.create(articleTypeDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ArticleTypeDto articleTypeDto) {
        Result result = articleTypeService.update(articleTypeDto, id);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delet(@PathVariable Integer id) {
        Result result = articleTypeService.delete(id);
        return result;
    }

}
