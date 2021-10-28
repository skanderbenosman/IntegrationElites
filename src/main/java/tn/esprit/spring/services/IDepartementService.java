package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	List<Departement> retrieveAllDepartements();
	Departement addDep(Departement dep);
	Departement updateDepartement(Departement dep);
	void deleteDepartement(String id);
	Departement retrieveDepartement(String id);
	
}
