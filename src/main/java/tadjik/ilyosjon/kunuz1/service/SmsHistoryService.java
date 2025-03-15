package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.SmsHistory;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.SmsHistoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SmsHistoryService {
    @Autowired
    SmsHistoryRepo smsHistoryRepo;

    // get all
    public List<SmsHistory> findAll() {
        return smsHistoryRepo.findAll();
    }

    // get by id
    public SmsHistory getbyid(Integer id) {
        return smsHistoryRepo.getById(id);
    }

    // create
    public Result createsmsgistory(SmsHistory smsHistorydto) {
        SmsHistory smsHistory = new SmsHistory();
        smsHistory.setPhone(smsHistorydto.getPhone());
        smsHistory.setMessage(smsHistorydto.getMessage());
        smsHistory.setType(smsHistorydto.getType());
        smsHistoryRepo.save(smsHistory);

        return new Result(true,"created");
    }

    // update
    public Result updatesmshistory(Integer id, SmsHistory smsHistorydto) {
        Optional<SmsHistory> smsHistoryOptional = smsHistoryRepo.findById(id);
        if(smsHistoryOptional.isPresent()){
            SmsHistory smsHistory = smsHistoryOptional.get();
            smsHistory.setPhone(smsHistorydto.getPhone());
            smsHistory.setMessage(smsHistorydto.getMessage());
            smsHistory.setType(smsHistorydto.getType());
            smsHistoryRepo.save(smsHistory);
            return new Result(true,"updated");
        }
        return new Result(false,"not found");
    }

    // delete
    public Result deletesmshistory(Integer id) {
        smsHistoryRepo.deleteById(id);
        return new Result(true,"deleted");
    }
}
