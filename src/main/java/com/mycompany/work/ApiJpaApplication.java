package com.mycompany.work;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycompany.work.controllers.PatientController;
import com.mycompany.work.entities.Patient;
import com.mycompany.work.repositories.IPatientRepository;

@SpringBootApplication
public class ApiJpaApplication {
	
	@Autowired
	private PatientController patientController;


	public static void main(String[] args) {
		SpringApplication.run(ApiJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientController patientController) {
		return args ->{

			patientController.save(new Patient(null, "patient3@gmail.com", "patient3", null));
			
			
			List<Patient> pt = patientController.findByNom("patient2");
			pt.forEach(p -> {
				System.out.println(p.getId());
				System.out.println(p.getNom());
				System.out.println("---------------------------");
			});
			
			
			patientController.findAll().forEach(p -> {
				System.out.println(p.getId());
				System.out.println(p.getNom());
				System.out.println(p.getEmail());
			});
		};
		
	}
}
