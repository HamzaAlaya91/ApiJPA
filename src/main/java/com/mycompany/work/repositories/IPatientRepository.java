package com.mycompany.work.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.work.entities.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
	
	List<Patient> findByNom(String name);

}
