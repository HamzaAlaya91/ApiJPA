package com.mycompany.work.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.work.entities.Groupe;
import com.mycompany.work.entities.Utilisateur;
import com.mycompany.work.repositories.IGroupeRepository;
import com.mycompany.work.repositories.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private IGroupeRepository iGroupeRepository;

	@Override
	public Utilisateur saveUser(Utilisateur utilisateur) {
		return iUserRepository.save(utilisateur);
	}

	@Override
	public Groupe saveGroupe(Groupe groupe) {
		return iGroupeRepository.save(groupe);
	}

	@Override
	public void addUserGroupe(String username, String groupename) {
		Groupe groupe = iGroupeRepository.findByGroupename(groupename);
		Utilisateur utilisateur = iUserRepository.findByUsername(username);
		groupe.getUtilisateurs().add(utilisateur);
		
	}

	@Override
	public Utilisateur findByUsername(String username) {	
		return iUserRepository.findByUsername(username);
	}

}
