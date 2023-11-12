package com.hackunt.students.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hackunt.students.entity.Dining;

public interface DiningService {

	void addNewDiningTable(Dining dining);

	void updateTable(Long tableid, Dining dining);

	void deleteTable(Long tableid);

	Dining getTableById(Long tableid);

	List<Dining> getAllTables();

	ResponseEntity<List<Long>> getTablesByAvailability(String availability);

}
