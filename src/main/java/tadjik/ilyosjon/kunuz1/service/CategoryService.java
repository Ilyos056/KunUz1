package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.CategoryDto;
import tadjik.ilyosjon.kunuz1.model.Category;
import tadjik.ilyosjon.kunuz1.model.Profile;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    //get all profile
    public List<Category> getall(){
        return categoryRepo.findAll();
    }

    //get by id
    public Category getbyid(Integer id){
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        return categoryOptional.get();
    }
    //create
    public Result add(CategoryDto categoryDto){

        Category category = new Category();
        category.setOrder_num(categoryDto.getOrder_num());
        category.setName_eng(categoryDto.getName_eng());
        category.setName_ru(categoryDto.getName_ru());
        category.setName_uz(categoryDto.getName_uz());
        categoryRepo.save(category);
        return new Result(true, "Created");
    }

    public Result update(Integer id, CategoryDto categoryDto){
        Optional<Category> categoryoptional = categoryRepo.findById(id);

        if (categoryoptional.isPresent()){
            Category category = categoryoptional.get();
            category.setName_uz(categoryDto.getName_uz());
            category.setName_eng(categoryDto.getName_eng());
            category.setName_ru(categoryDto.getName_ru());
            categoryRepo.save(category);
            return new Result(true, "Updated");
        }
        return new Result(false, "Profile not found");
    }

    public Result delet(Integer id){
        categoryRepo.deleteById(id);
        return new Result(true, "Deleted");
    }


}
