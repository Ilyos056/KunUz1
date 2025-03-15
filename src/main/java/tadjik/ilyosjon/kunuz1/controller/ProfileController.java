package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.ProfileDto;
import tadjik.ilyosjon.kunuz1.model.Profile;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public List<Profile> getAll(){
        List<Profile> list = profileService.getall();
        return list;
    }

    @GetMapping("/{id}")
    public Profile getByid(@PathVariable Integer id) {
        Profile byid = profileService.getbyid(id);
        return byid;
    }

    @PostMapping
    public Result create(@RequestBody ProfileDto profileDto) {
        Result result = profileService.create(profileDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ProfileDto profileDto) {
        Result result = profileService.update(id, profileDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delet(@PathVariable Integer id) {
        Result result = profileService.delet(id);
        return result;
    }

}
