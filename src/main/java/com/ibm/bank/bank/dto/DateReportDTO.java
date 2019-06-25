package com.ibm.bank.bank.dto;

import java.util.Date;

public class DateReportDTO {

    private Date initDate;
    private Date finalDate;

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    @Override
    public String toString() {
        return "DateReportDTO{" +
                "initDate=" + initDate +
                ", finalDate=" + finalDate +
                '}';
    }
}
