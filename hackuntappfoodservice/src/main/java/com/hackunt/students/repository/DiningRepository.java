package com.hackunt.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackunt.students.entity.Dining;

@Repository
public interface DiningRepository extends JpaRepository<Dining, Long> {
	public List<Long> findByTableAvailability(String availability);

}