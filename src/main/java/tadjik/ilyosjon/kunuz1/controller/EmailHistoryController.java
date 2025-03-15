package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.EmailHistoryDto;
import tadjik.ilyosjon.kunuz1.model.EmailHistory;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.EmailHistoryService;

import java.util.List;

@RestController
@RequestMapping("/emailhistory")
public class EmailHistoryController {
    @Autowired
    EmailHistoryService emailHistoryService;


    @GetMapping
    public List<EmailHistory> getEmailHistory(){
        return emailHistoryService.getallemail();
    }

    @GetMapping("/{id}")
    public EmailHistory getEmailHistory(@PathVariable Integer id){
        return emailHistoryService.getbyidemail(id);
    }

    @PostMapping
    public Result createEmailHistory(@RequestBody EmailHistoryDto emailHistorydto){
        Result result = emailHistoryService.createemail(emailHistorydto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateEmailHistory(@PathVariable Integer id, @RequestBody EmailHistoryDto emailHistorydto){
        Result result = emailHistoryService.updateemail(id, emailHistorydto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteEmailHistory(@PathVariable Integer id){
        Result result = emailHistoryService.deleteemail(id);
        return result;
    }
}
