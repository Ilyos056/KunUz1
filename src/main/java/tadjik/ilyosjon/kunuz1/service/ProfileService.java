package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.ProfileDto;
import tadjik.ilyosjon.kunuz1.model.Profile;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    //get all profile
    public List<Profile> getall(){
        return profileRepo.findAll();
    }

    //get by id
    public Profile getbyid(Integer id){
        Optional<Profile> profileOptional = profileRepo.findById(id);
        return profileOptional.get();
    }
    //create
    public Result create(ProfileDto profileDto){

        boolean exists = profileRepo.existsByEmailAndPhone(profileDto.getEmail(), profileDto.getPhone());
        if (exists){
            return new Result(false, "Bunday foydalanuvchi allaqachon mavjud");
        }
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPhone(profileDto.getPhone());
        profile.setPassword(profileDto.getPassword());
        profileRepo.save(profile);
        return new Result(true, "Created");
    }

    public Result update(Integer id, ProfileDto profileDto){
        Optional<Profile> optional = profileRepo.findById(id);

        if (optional.isPresent()){
            Profile profile = optional.get();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPhone(profileDto.getPhone());
            profile.setPassword(profileDto.getPassword());
            profileRepo.save(profile);
            return new Result(true, "Updated");
        }
        return new Result(false, "Profile not found");
    }

    public Result delet(Integer id){
        profileRepo.deleteById(id);
        return new Result(true, "Deleted");
    }
}
