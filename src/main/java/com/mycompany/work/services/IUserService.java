package com.mycompany.work.services;

import com.mycompany.work.entities.Groupe;
import com.mycompany.work.entities.Utilisateur;

public interface IUserService {

	Utilisateur saveUser(Utilisateur utilisateur);
	Groupe saveGroupe(Groupe groupe);
	void addUserGroupe(String username, String groupename);
	Utilisateur findByUsername(String username);
}
