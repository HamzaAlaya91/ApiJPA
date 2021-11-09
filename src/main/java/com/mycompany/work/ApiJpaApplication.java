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
import com.mycompany.work.entities.Groupe;
import com.mycompany.work.entities.Patient;
import com.mycompany.work.entities.Utilisateur;
import com.mycompany.work.repositories.IPatientRepository;
import com.mycompany.work.repositories.IUserRepository;
import com.mycompany.work.services.IUserService;

@SpringBootApplication
public class ApiJpaApplication {
	
	@Autowired
	private PatientController patientController;
	
	@Autowired
	private IUserService iUserService;


	public static void main(String[] args) {
		SpringApplication.run(ApiJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientController patientController) {
		return args ->{

//			patientController.save(new Patient(null, "patient3@gmail.com", "patient3", null));
//			
//			
//			List<Patient> pt = patientController.findByNom("patient2");
//			pt.forEach(p -> {
//				System.out.println(p.getId());
//				System.out.println(p.getNom());
//				System.out.println("---------------------------");
//			});
//			
//			
//			patientController.findAll().forEach(p -> {
//				System.out.println(p.getId());
//				System.out.println(p.getNom());
//				System.out.println(p.getEmail());
//			});
		
			iUserService.saveUser(new Utilisateur(null, "user1", "password1", null));
			iUserService.saveUser(new Utilisateur(null, "user2", "password2", null));
			
			iUserService.saveGroupe(new Groupe(null, "USER", null));
			iUserService.saveGroupe(new Groupe(null, "ADMIN", null));
			
			iUserService.addUserGroupe("user1", "USER");
			iUserService.addUserGroupe("user2", "USER");
			iUserService.addUserGroupe("user2", "ADMIN");
			
			Utilisateur utilisateur = iUserService.findByUsername("user2");
			System.out.println("Username : " + utilisateur.getUsername());
			System.out.println("Password : " + utilisateur.getPassword());

			System.out.println("Groupes :");
			utilisateur.getGroupes().forEach(g -> {
				System.out.println("Groupe : " +g.getGroupename());
			});		
			
		};
		
	}
}
