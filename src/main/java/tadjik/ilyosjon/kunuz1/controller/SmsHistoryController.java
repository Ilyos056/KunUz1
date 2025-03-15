package tadjik.ilyosjon.kunuz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.kunuz1.dto.SmsHistory;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.service.EmailHistoryService;
import tadjik.ilyosjon.kunuz1.service.SmsHistoryService;

import java.util.List;

@RestController
@RequestMapping("/smshistory")
public class SmsHistoryController {
    @Autowired
    SmsHistoryService smsHistoryService;
    @Autowired
    private EmailHistoryService emailHistoryService;

    @GetMapping
    public HttpEntity<?> getall(){
        List<SmsHistory> smsHistories = smsHistoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(smsHistories);
    }

    @GetMapping("/{id}")
    public HttpEntity getbyidemail(@PathVariable Integer id){
        emailHistoryService.getbyidemail(id);
        return new ResponseEntity<>(emailHistoryService.getbyidemail(id), HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody SmsHistory smsHistorydto){
        Result result = smsHistoryService.createsmsgistory(smsHistorydto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody SmsHistory smsHistorydto){
        Result result = smsHistoryService.updatesmshistory(id, smsHistorydto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteSmsHistory(@PathVariable Integer id){
        Result result = smsHistoryService.deletesmshistory(id);
        return result;
    }
}
