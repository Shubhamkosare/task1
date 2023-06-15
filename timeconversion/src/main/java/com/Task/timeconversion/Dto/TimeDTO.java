package com.Task.timeconversion.Dto;

import java.time.LocalTime;

public class TimeDTO {

    private LocalTime time;

    public TimeDTO() {
    }

    public TimeDTO(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}