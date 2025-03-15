package tadjik.ilyosjon.kunuz1.controller;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.ArticleTypeDto;
import tadjik.ilyosjon.kunuz1.dto.RegionDto;
import tadjik.ilyosjon.kunuz1.model.Article_Type;
import tadjik.ilyosjon.kunuz1.model.Region;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/Region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping
    public List<Region> getAll() {
        List<Region> list = regionService.getall();
        return list;
    }

    @GetMapping("/{id}")
    public Region getByid(@PathVariable Integer id) {
        Region byid = regionService.getbyid(id);
        return byid;
    }

    @PostMapping
    public Result create(@RequestBody RegionDto regionDto) {
        Result result = regionService.creat(regionDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody RegionDto regionDto) {
        Result result = regionService.update(id, regionDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delet(@PathVariable Integer id) {
        Result result = regionService.delet(id);
        return result;
    }
}
