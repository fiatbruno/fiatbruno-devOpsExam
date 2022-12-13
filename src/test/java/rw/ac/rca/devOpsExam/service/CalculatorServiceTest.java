package rw.ac.rca.devOpsExam.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import rw.ac.rca.devOpsExam.domain.Calculator;
import rw.ac.rca.devOpsExam.dto.DoMathRequestDTO;
import rw.ac.rca.devOpsExam.repository.CalculatorRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

    @Mock
    private CalculatorRepository calculatorRepositoryMock;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    public void getById_success() {
        Long id = 104L;
        Calculator calculator = new Calculator(id);
        when(calculatorRepositoryMock.findById(id)).thenReturn(Optional.of(Calculator));
        assertEquals(104L, calculatorService.getById(id));
    }

    @Test
    public void getById_fail() {
        Long id = 1000L;
        when(calculatorRepositoryMock.findById(id)).thenReturn(Optional.empty());
        Calculator calculator = calculatorService.getById(id);
        assertTrue(calculator == null);
    }

    @Test
    public void save_success() {
        DoMathRequestDTO dto = new DoMathRequestDTO();
        dto.setId(102L);
        Calculator Calculator = new Calculator(dto.getId());
        when(calculatorRepositoryMock.save(Calculator)).thenReturn(Calculator);
        Calculator createCalculator = calculatorService.save(dto);
        assertTrue(createCalculator.getId() == 102L);
    }

}
