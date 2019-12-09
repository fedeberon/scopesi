package com.ideaas.services.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeUtil {

    public static LocalDateTime convertToLocalDateTimeViaSqlTimestamp(Date dateToConvert) {
        assert dateToConvert != null : "[ERROR-SCOPESSI] * Date must´n be null";
        return new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime();
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
