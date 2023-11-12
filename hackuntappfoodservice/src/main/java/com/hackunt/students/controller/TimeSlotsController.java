package com.hackunt.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackunt.students.dto.TimeSlotsDto;
import com.hackunt.students.dto.TimeSlotsDto;
import com.hackunt.students.entity.TimeSlots;
import com.hackunt.students.service.TimeSlotsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/TimeSlots/v1")

public class TimeSlotsController {
   
	@Autowired
    private TimeSlotsService TimeSlotsService;

    @PostMapping("/addtimeslot")
    public ResponseEntity<TimeSlots> createTimeSlots(@RequestBody TimeSlotsDto TimeSlotsDto) {
        TimeSlots createdTimeSlots = TimeSlotsService.createTimeSlots(TimeSlotsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTimeSlots);
    }

    @GetMapping("/getalltimeslots")
    public List<TimeSlots> getAllTimeSlotss() {
        return TimeSlotsService.getAllTimeSlots();
    }

    @GetMapping("/gettimeslotbyid/{timeid}")
    public ResponseEntity<TimeSlots> getTimeSlotsById(@PathVariable Long timeid) {
        TimeSlots TimeSlots = TimeSlotsService.getTimeSlotsById(timeid);
        return TimeSlots != null ? ResponseEntity.ok(TimeSlots) : ResponseEntity.notFound().build();
    }

    @PutMapping("/updatetimeslot/{timeid}")
    public ResponseEntity<TimeSlots> updateTimeSlots(@PathVariable Long timeid, @RequestBody TimeSlots updatedTimeSlots) {
        TimeSlots updatedTimeSlotsEntity = TimeSlotsService.updateTimeSlots(timeid, updatedTimeSlots);
        return updatedTimeSlotsEntity != null
                ? ResponseEntity.ok(updatedTimeSlotsEntity)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletetimeslot/{timeid}")
    public ResponseEntity<Void> deleteTimeSlots(@PathVariable Long timeid) {
    	TimeSlotsService.deleteTimeSlots(timeid);
        return ResponseEntity.noContent().build();
    }

}
