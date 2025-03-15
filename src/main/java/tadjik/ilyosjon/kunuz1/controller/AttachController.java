package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.AttachDto;
import tadjik.ilyosjon.kunuz1.model.Attach;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.AttachService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/attach")
public class AttachController {

    @Autowired
    AttachService attachService;

    @GetMapping
    public List<Attach> findAll(){
        return attachService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Attach> findOne(@PathVariable UUID id){
        return attachService.findById(id);
    }

    @PostMapping
    public Result save(@RequestBody AttachDto attachdto){
        Result result = attachService.createattach(attachdto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable UUID id, @RequestBody AttachDto attachdto){
        Result result = attachService.updateattach(id, attachdto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable UUID id){
        Result result = attachService.deleteattach(id);
        return result;
    }
}
