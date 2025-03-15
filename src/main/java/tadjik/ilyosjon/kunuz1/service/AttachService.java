package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.AttachDto;
import tadjik.ilyosjon.kunuz1.model.Attach;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.AttachRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachService {
    @Autowired
    AttachRepo attachRepo;


    // get all
    public List<Attach> findAll(){
        return attachRepo.findAll();
    }

    // get by id
    public Optional<Attach> findById(UUID uuid){
        return attachRepo.findById(uuid);
    }

    // create
    public Result createattach(AttachDto attachdto){
        Attach attach = new Attach();
        attach.setOriginal_name(attachdto.getOriginal_name());
        attach.setPath(attachdto.getPath());
        attach.setSize(attachdto.getSize());
        attach.setExtension(attachdto.getExtension());
        attachRepo.save(attach);
        return new Result(true,"Attach created successfully");
    }


    // update
    public Result updateattach(UUID uuid, AttachDto attachdto){
        Optional<Attach> attachOptional = attachRepo.findById(uuid);
        if (attachOptional.isPresent()) {
            Attach attach = attachOptional.get();
            attach.setOriginal_name(attachdto.getOriginal_name());
            attach.setPath(attachdto.getPath());
            attach.setSize(attachdto.getSize());
            attach.setExtension(attachdto.getExtension());
            attachRepo.save(attach);
            return new Result(true,"Attach updated successfully");
        }
        return new Result(false,"Attach not found");
    }


    // delete
    public Result deleteattach(UUID uuid){
        attachRepo.deleteById(uuid);
        return new Result(true,"Attach deleted successfully");
    }
}
