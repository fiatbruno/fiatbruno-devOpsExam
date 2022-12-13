package rw.ac.rca.devOpsExam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.ac.rca.devOpsExam.domain.Calculator;
import rw.ac.rca.devOpsExam.dto.DoMathRequestDTO;
import rw.ac.rca.devOpsExam.repository.CalculatorRepository;

@Service
public class CalculatorService {

	@Autowired
	private CalculatorRepository calculatorRepository;

	public Calculator getById(long id) {
		Optional<Calculator> found = calculatorRepository.findById(id);
		if(found.isPresent()) {
			Calculator calculator = found.get();
			return calculator;
		}

		return null;
	}

	private Double doMath(double operand1, double operand2, String operation) throws InvalidOperationException{
		if("/".equals(operation) && operand2 == (double) 0) {
			throw new InvalidOperationException("Can't divide by 0");
		}

		switch (operation) {
			case "*":
				return operand1 * operand2;
			case "/":
				return operand1 / operand2;
			case "+":
				return operand1 + operand2;
			case "-":
				return operand1 - operand2;
			case "**":
				return Math.pow(operand1, operand2);
			case "log":
				return operand1 * Math.log10(operand2);
			case "ln":
				return operand1 * Math.log(operand2);
			default:
				throw new RunTimeException("Unknown operation");
		}
	}
	

}
