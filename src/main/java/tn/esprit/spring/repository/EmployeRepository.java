package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;

@Repository
public interface EmployeRepository extends  CrudRepository<Employe, Long> {

}
