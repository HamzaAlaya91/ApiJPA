package com.mycompany.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.work.entities.Utilisateur;

public interface IUserRepository extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByUsername(String username);
}
