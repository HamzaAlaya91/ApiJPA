package com.mycompany.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.work.entities.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {

}
