package rw.ac.rca.devOpsExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rw.ac.rca.devOpsExam.domain.Calculator;

@Repository
public interface CalculatorRepository extends JpaRepository<Calculator, Long> {

}
