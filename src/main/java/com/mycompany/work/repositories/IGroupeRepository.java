package com.mycompany.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.work.entities.Groupe;
import com.mycompany.work.entities.Utilisateur;

public interface IGroupeRepository extends JpaRepository<Groupe, Long> {
	Groupe findByGroupename(String groupename);


}
