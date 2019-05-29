package com.ictcg.practical_assessment.service;

import com.ictcg.practical_assessment.model.Date;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class DateRepositoryImpl {

    public Date getDate(String countryCode) {

        Date dateModel = new Date();

        dateModel.setLocalDate(LocalDate.now());
        dateModel.setLocalTime(LocalTime.now());

        if (countryCode.equals("US")) {

            DateTimeFormatter usaDateFormat = DateTimeFormatter.ofPattern("MMM dd yyyy");
            DateTimeFormatter usaTimeFormat = DateTimeFormatter.ofPattern("h:mm a");

            String uDate = dateModel.getLocalDate().format(usaDateFormat);
            String uTime = dateModel.getLocalTime().format(usaTimeFormat);

            return dateModel;

        } else if (countryCode.equals("EU")) {

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.FRENCH);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm", Locale.FRENCH);

            String sDate = dateModel.getLocalDate().format(dateFormatter);
            String sTime = dateModel.getLocalTime().format(timeFormatter);

            return dateModel;

        } else {

            return null;
        }

    }

}