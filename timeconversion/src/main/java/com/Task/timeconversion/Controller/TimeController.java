package com.Task.timeconversion.Controller;

import com.Task.timeconversion.Dto.TimeDTO;
import com.Task.timeconversion.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/time")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/{time}")
    public ResponseEntity<String> convertTimeToWords(@PathVariable String time) {
        try {
            LocalTime localTime = LocalTime.parse(time);
            TimeDTO timeDTO = new TimeDTO(localTime);

            String timeInWords = timeService.convertTimeToWords(timeDTO);
            return ResponseEntity.ok(timeInWords);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid time format");
        }
    }
}

