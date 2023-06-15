package com.Task.timeconversion.Service.Impl;

import com.Task.timeconversion.Dto.TimeDTO;
import com.Task.timeconversion.Service.TimeService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public String convertTimeToWords(TimeDTO timeDTO) {
        LocalTime localTime = timeDTO.getTime();

        if (localTime.equals(LocalTime.NOON)) {
            return "It's Midday";
        } else if (localTime.equals(LocalTime.MIDNIGHT)) {
            return "It's Midnight";
        } else {
            String hourInWords = convertToWords(localTime.getHour());
            String minuteInWords = convertToWords(localTime.getMinute());
            return "It's " + hourInWords + " " + minuteInWords;
        }
    }

    private String convertToWords(int number) {
        String[] ones = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = {
                "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        if (number == 0) {
            return "zero";
        } else if (number < 20) {
            return ones[number];
        } else if (number < 100) {
            return tens[number / 10] + " " + ones[number % 10];
        } else {
            return "Invalid number";
        }
    }
}