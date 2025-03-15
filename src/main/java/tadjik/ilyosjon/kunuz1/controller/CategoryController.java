package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.ArticleTypeDto;
import tadjik.ilyosjon.kunuz1.dto.CategoryDto;
import tadjik.ilyosjon.kunuz1.model.Category;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.CategoryService;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAll(){
        List<Category> list = categoryService.getall();
        return list;
    }

    @GetMapping("/{id}")
    public Category getByid(@PathVariable Integer id) {
        Category byid = categoryService.getbyid(id);
        return byid;
    }

    @PostMapping
    public Result create(@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.add(categoryDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        Result result = categoryService.update(id, categoryDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delet(@PathVariable Integer id) {
        Result result = categoryService.delet(id);
        return result;
    }
}
