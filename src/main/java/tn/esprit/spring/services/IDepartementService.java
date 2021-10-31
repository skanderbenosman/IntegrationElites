package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	List<Departement> retrieveAllDepartements();
	Departement addDep(Departement dep);
	Departement updateDepartement(Departement dep);
	int deleteDepartement(int id);
	Departement retrieveDepartement(int id);
	Departement affecterDepartementAEntreprise(int depId, int entrepriseId);
	Departement desaffecterDepartementAEntreprise(int depId, int entrepriseId)
	
}
