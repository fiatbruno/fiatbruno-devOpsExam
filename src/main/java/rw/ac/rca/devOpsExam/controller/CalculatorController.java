package rw.ac.rca.devOpsExam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.ac.rca.devOpsExam.domain.Calculator;
import rw.ac.rca.devOpsExam.dto.DoMathRequestDTO;
import rw.ac.rca.devOpsExam.service.CalculatorService;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	@GetMapping("/id/{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {

		Calculator calculator = calculatorService.getById(id);

		if (calculator != null) {
			return ResponseEntity.status(HttpStatus.OK).body(calculator);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND);
	}


	@PostMapping("/calculate")
	public ResponseEntity<?> doMath(@RequestBody DoMathRequestDTO dto) {

		Calculator calculator = calculatorService.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(city);
	}
}
