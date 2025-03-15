package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.ArticleTypeDto;
import tadjik.ilyosjon.kunuz1.model.Article_Type;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.ArticleTypeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleTypeService {

    @Autowired
    ArticleTypeRepo articleTypeRepo;

    public List<Article_Type> getAll() {
        return articleTypeRepo.findAll();
    }

    public Article_Type getById(Integer id) {
        return articleTypeRepo.findById(id).get();
    }

    public Result create(ArticleTypeDto articleTypeDto) {
        Article_Type articleType = new Article_Type();
        articleType.setCreatedDate(articleTypeDto.getCreatedDate());
        articleType.setOrdernumber(articleTypeDto.getOrder_num());
        articleType.setNameuz(articleTypeDto.getNameuz());
        articleType.setNameru(articleTypeDto.getNameru());
        articleType.setNameeng(articleTypeDto.getNameeng());
        articleTypeRepo.save(articleType);
        return new Result(true, "Article Type Created Successfully");
    }

    public Result update(ArticleTypeDto articleTypeDto, Integer id) {
        Optional<Article_Type> byId = articleTypeRepo.findById(id);
        if (byId.isPresent()) {
            Article_Type articleType = byId.get();
            articleType.setCreatedDate(articleTypeDto.getCreatedDate());
            articleType.setOrdernumber(articleTypeDto.getOrder_num());
            articleType.setNameuz(articleTypeDto.getNameuz());
            articleType.setNameru(articleTypeDto.getNameru());
            articleType.setNameeng(articleTypeDto.getNameeng());
            articleTypeRepo.save(articleType);
            return new Result(true, "Article Type Updated Successfully");
        }
        return new Result(false, "Article Type Not Found");
    }

    public Result delete(Integer id) {
        articleTypeRepo.deleteById(id);
        return new Result(true, "Article Type Deleted Successfully");
    }

}
