package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	List<Departement> retrieveAllDepartements();
	Departement addDep(Departement dep);
	Departement updateDepartement(Departement dep);
	Departement retrieveDepartement(int id);
	int deleteDepartementById(int depId);
	Departement desaffecterDepartementDuEntreprise(int depId, int entId);
	Departement affecterDepartementAEntreprise(int depId, int entrepriseId);
	
}
