package com.ibm.bank.bank.services;

import com.ibm.bank.bank.business.ReportBusiness;
import com.ibm.bank.bank.dto.DateReportDTO;
import com.ibm.bank.bank.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ReportService {

    @Autowired
    private ReportBusiness reportBusiness;

    @RequestMapping(value = "/generateReport", method = RequestMethod.POST)
    public byte[] generateReport(@RequestBody DateReportDTO dateReportDTO) {
        try{
            return this.reportBusiness.generateReport(dateReportDTO);
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

