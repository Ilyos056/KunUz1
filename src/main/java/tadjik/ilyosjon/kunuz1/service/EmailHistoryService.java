package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.EmailHistoryDto;
import tadjik.ilyosjon.kunuz1.model.EmailHistory;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.EmailHistoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmailHistoryService {

    @Autowired
    EmailHistoryRepo emailHistoryRepo;


    // get all
    public List<EmailHistory> getallemail(){
        return emailHistoryRepo.findAll();
    }

    // get by id
    public EmailHistory getbyidemail(Integer id){
        return emailHistoryRepo.findById(id).get();
    }


    // create
    public Result createemail(EmailHistoryDto emailHistorydto){
        EmailHistory emailHistory = new EmailHistory();
        emailHistory.setMessage(emailHistorydto.getMessage());
        emailHistory.setEmail(emailHistorydto.getEmail());
        emailHistoryRepo.save(emailHistory);

        return new Result(true,"success");
    }

    // update
    public Result updateemail(Integer id, EmailHistoryDto emailHistorydto){
        Optional<EmailHistory> emailHistory = emailHistoryRepo.findById(id);
        if(emailHistory.isPresent()){
            emailHistory.get().setMessage(emailHistorydto.getMessage());
            emailHistory.get().setEmail(emailHistorydto.getEmail());
            emailHistoryRepo.save(emailHistory.get());
            return new Result(true,"success");
        }
        return new Result(false,"email not found");
    }

    // delete
    public Result deleteemail(Integer id){
        emailHistoryRepo.deleteById(id);
        return new Result(true,"success");
    }
}
